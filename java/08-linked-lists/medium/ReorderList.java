/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
//  Start = O(n)    ,    Space = O(1)
public class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null) return;
        ListNode curr=head, end=head, start=head;
        int n=0, half;
        while (end!=null)  {end=end.next;   n++;}
        half=n/2;
        end=head;
        while(half!=0)  {end=end.next;  half--;}
        curr=end.next;
        end.next=null;
        curr=reverseList(curr);
        while(curr!=null &&  start!=null){
            end=start.next;
            start.next=curr;
            curr=curr.next;
            start=start.next;
            start.next=end;
            start=start.next;
        }
    }

    //reverse list method 
        public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        ListNode nextNode;
        while (current != null){
            nextNode=current.next; 
            current.next=prev;
            prev=current;
            current=nextNode;
        }
        return prev;
    }
}
