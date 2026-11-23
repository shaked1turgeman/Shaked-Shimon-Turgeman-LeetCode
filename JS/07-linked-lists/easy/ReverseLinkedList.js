// Time: O(n)   ,   Space: O(1)
/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var reverseList = function(head) {
    let curr = head, prev = null;
    while(curr!==null){
        let temp = curr;
        curr=curr.next;
        temp.next = prev;
        prev = temp;
    }
    return prev;
};

function ListNode(val, next) {
    this.val = (val === undefined ? 0 : val);
    this.next = (next === undefined ? null : next);
}
