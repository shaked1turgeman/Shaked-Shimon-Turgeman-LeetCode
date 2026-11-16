public class MyCalendarTwo {
    private Node root;

    public MyCalendarTwo() {
        root = new Node();
    }
    
    public boolean book(int startTime, int endTime) {
        int max = query(root, 0, 999999999, startTime, endTime - 1);
        if (max >= 2) return false;
        update(root, 0, 999999999, startTime, endTime - 1);
        return true;
    }

    private int query(Node node, int l, int r, int start, int end){
        if(node==null || start>r || end<l)  return 0;
        if((start <= l && r <= end))    return node.max;
        int mid = l + (r - l) / 2;
        int leftChild=query(node.left,l,mid,start,end); 
        int rightChild=query(node.right,mid+1,r,start,end);
        return node.lazy + Math.max(leftChild, rightChild);
    }

    private void update(Node node, int l, int r, int start, int end){
        if (start <= l && r <= end) {
            node.lazy++;
            node.max++;
            return;
        }
        int mid = l + (r - l) / 2;
        if (start <= mid) {
            if (node.left == null)  node.left = new Node();
            update(node.left, l, mid, start, end);
        }
        if (end > mid) {
            if (node.right == null) node.right = new Node();
            update(node.right, mid + 1, r, start, end);
        }
        int leftMax = node.left == null ? 0 : node.left.max;
        int rightMax = node.right == null ? 0 : node.right.max;
        node.max = node.lazy + Math.max(leftMax, rightMax);
    }
}

class Node {
    Node left, right;
    int max = 0;
    int lazy = 0;
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(startTime,endTime);
 */
