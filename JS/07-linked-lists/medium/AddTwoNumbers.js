// Time: O(max(m, n))   ,   Space: O(1) auxiliary, excluding output
/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */
var addTwoNumbers = function(l1, l2) {
    let head = new ListNode((l1.val+l2.val)%10,undefined), curr = head;
    let c = Math.floor((l1.val + l2.val) / 10);
    l1 = l1.next;
    l2 = l2.next;
    while(l1!==null && l2!==null){
        curr.next = new ListNode((l1.val+l2.val+c)%10,undefined);
        c = Math.floor((l1.val + l2.val + c) / 10);
        curr = curr.next;
        l1 = l1.next;
        l2 = l2.next;
    }
    while(l2 !== null){
        curr.next = new ListNode((l2.val+c)%10,undefined);
        c = Math.floor((c + l2.val) / 10);
        curr = curr.next;
        l2=l2.next;
    }   
    while(l1 !== null){
        curr.next = new ListNode((l1.val+c)%10,undefined);
        c = Math.floor((c + l1.val) / 10);
        curr = curr.next;
        l1=l1.next;
    }
    if(c!==0)   curr.next = new ListNode(c,undefined);
    return head;
};
