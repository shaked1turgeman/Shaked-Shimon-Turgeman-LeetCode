// Time = O(n)   ,   Space = O(n)
/**
 * // Definition for a _Node.
 * function _Node(val, next, random) {
 *    this.val = val;
 *    this.next = next;
 *    this.random = random;
 * };
 */

/**
 * @param {_Node} head
 * @return {_Node}
 */
var copyRandomList = function(head) {
    if (head === null) return null;
    let temp = head, newList = null, secTemp = null;
    // loop for alternating insertion of new nodes in between
    while(temp!==null){
        let alter = new _Node(temp.val);
        alter.next = temp.next;
        temp.next = alter;
        temp = temp.next.next;
    }
    temp = head;
    // loop for makeing the rand connections
    while(temp!==null){
        temp.next.random = temp.random === null ? null : temp.random.next;
        temp = temp.next.next;
    }
    temp = head;
    newList = head.next;
    secTemp = newList;
    // loop for spliting the new list away
    while(temp!==null){
        temp.next = secTemp.next;
        secTemp.next = secTemp.next === null ? null : secTemp.next.next;
        temp = temp.next;
        secTemp = secTemp.next;
    }
    return newList;
};
