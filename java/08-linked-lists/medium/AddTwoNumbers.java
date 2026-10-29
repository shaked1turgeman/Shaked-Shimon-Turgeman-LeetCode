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
// Time = O(max(m,n))   ,   Space = O(1)
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res=new ListNode();
        ListNode runner=res;
        int carry=0;
        while(l1!=null && l2!=null){
            int sum = l1.val+l2.val+carry;
            carry=sum/10;
            runner.val=sum%10;
            l1=l1.next;
            l2=l2.next;
            if(l1!=null || l2!=null) {runner.next=new ListNode();   runner=runner.next;}
        }
        // in case l2 has more digits
        while(l2!=null){ 
            int sum = l2.val+carry;
            carry=sum/10;
            runner.val=sum%10;
            l2=l2.next;
            if(l2!=null)  {runner.next=new ListNode();   runner=runner.next;}
        }
        // in case l1 has more digits
        while(l1!=null){ 
            int sum = l1.val+carry;
            carry=sum/10;
            runner.val=sum%10;
            l1=l1.next;
            if(l1!=null)  {runner.next=new ListNode();   runner=runner.next;}
        }
        if(carry!=0) 
            {runner.next=new ListNode();   runner=runner.next;    runner.val=carry;}   
        return res;
    }
}
