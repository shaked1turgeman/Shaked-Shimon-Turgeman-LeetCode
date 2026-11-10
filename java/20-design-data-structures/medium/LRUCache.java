public class LRUCache {
    private int capacity;
    private Map<Integer,Node> map;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity; 
        this.map = new HashMap<>();
        this.head=null;
        this.tail=null;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node curr = map.get(key);
            if (curr == head) return curr.value;
            if (curr == tail) tail = curr.prev;
            if (curr.prev != null)    curr.prev.next=curr.next;
            if (curr.next != null)     curr.next.prev=curr.prev;
            curr.next=head;
            head.prev=curr;
            curr.prev = null;
            head=curr;
            return curr.value;
        }
        else return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node curr = map.get(key);
            if(curr==head) {head.value=value; return;}
            if(curr==tail )  tail=tail.prev;
            if(curr.prev!=null)    curr.prev.next=curr.next;
            if(curr.next!=null)     curr.next.prev=curr.prev;
            curr.next=head;
            head.prev=curr;
            head=curr;
            curr.value=value;
            curr.prev = null;
        }
        else{
            if(head!=null){
                Node curr = new Node(key,value);
                head.prev=curr;
                curr.next=head;
                head=curr;
                curr.prev = null;
            }
            else    {head=new Node(key,value); tail=head;}
            map.put(key,head);
        }
        if(map.size()>capacity) 
            {map.remove(tail.key); tail.prev.next=null; tail=tail.prev;}
    }
    
    private static class Node {
        int key, value;
        Node prev, next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.prev=null;
            this.next=null;
        }
    }
}



/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
