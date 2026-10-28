/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
// Time = O(n)   Space = O(1)
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        ListNode fast=head, slow=head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast)  return true;
        }
        return false;
    }
}
