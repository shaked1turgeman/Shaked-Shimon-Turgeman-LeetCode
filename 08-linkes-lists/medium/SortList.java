package medium;
import common.ListNode;
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
//  Time = O(n*log(n))   ,   Space = O(1)
public class SortList {
    public ListNode sortList(ListNode head) {
        int length = 0;
        ListNode curr = head;
        while (curr != null) {length++; curr = curr.next;}
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        for (int size = 1; size < length; size *= 2){
            ListNode prev = dummy;
            ListNode current = dummy.next;
            while (current != null){
                ListNode left = current;
                ListNode right = split(left, size);
                current = split(right, size);
                ListNode merged = merge(left, right);
                prev.next = merged;
                while (prev.next != null)   {prev = prev.next;}
            }
        }
        return dummy.next;
    }

    private ListNode split(ListNode head, int size) {
        if (head == null) return null;
        int steps = 0;
        ListNode current=head, rest;
        while (steps < size - 1 && current.next!=null) {
            current = current.next;
            steps++;
        }
        rest = current.next;
        current.next = null;
        return rest;
    }

    private ListNode merge(ListNode a, ListNode b) {
        ListNode head, tail;
        if(a==null) return b;
        else if(b==null) return a;
        else if(a.val<=b.val)    {head=a;    a=a.next;}  
        else    {head=b;    b=b.next;}
        tail=head;
        while(a!=null  &&  b!=null){
            if(a.val<=b.val){
                tail.next=a;
                a=a.next;
                tail=tail.next;
            }
            else{
                tail.next=b;
                b=b.next;
                tail=tail.next;
            }
        }
        if(a!=null) tail.next=a;
        else   tail.next=b;
        return head;
    }
}
