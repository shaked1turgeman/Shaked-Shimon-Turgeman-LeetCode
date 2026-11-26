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
 * @return {void} Do not return anything, modify head in-place instead.
 */
var reorderList = function(head) {
    let slow = head, fast = head, first = head;
    while (fast.next !== null && fast.next.next !== null) {
        slow = slow.next;
        fast = fast.next.next;
    }
    let second = slow.next;
    slow.next = null;
    second = reverseList(second);
    while(second!==null){
        let nextFirst = first.next, nextSecond = second.next;
        first.next = second;
        second.next = nextFirst;
        first = nextFirst;
        second = nextSecond;
    }
};

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
