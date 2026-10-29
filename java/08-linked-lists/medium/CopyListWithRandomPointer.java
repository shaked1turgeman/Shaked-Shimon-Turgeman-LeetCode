/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
//  Time = O(n)   ,   Space = O(1)
public class CopyListWithRandomPointer {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node runner = head;
        while(runner!=null){
            Node temp = new Node(runner.val);
            temp.next=runner.next;
            runner.next=temp;
            runner=runner.next.next;
        }
        runner=head;
        while(runner!=null){
            if(runner.random!=null) runner.next.random=runner.random.next;  
            else    runner.next.random=null;
            runner=runner.next.next;
        }
        runner=head;
        Node head1=head.next, runner1=head.next;
        while(runner!=null){
            runner.next=runner1.next;
            runner=runner.next;
            if(runner!=null)   runner1.next=runner.next;
            runner1=runner1.next;
        }
        return head1;
    }
}
