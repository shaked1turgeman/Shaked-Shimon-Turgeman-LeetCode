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
//  Time = O(L)   ,   Space = O(1)  | With one pass on linked list constraint
public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count=n+1;
        ListNode fast=head, slow=head;
        while(count!=0 && fast!=null)   {fast=fast.next;  count--;}
        if(count==1)    return head.next;
        while(fast!=null)   {fast=fast.next;    slow=slow.next;}
        slow.next=slow.next.next;
        return head;
    }
}
