// Time: O(n)   ,   Space: O(n)
/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number[][]}
 */
var levelOrder = function(root) {
    if (root === null) return [];
    const res = [], queue = [root];
    let front = 0;

    while (front < queue.length){
        const levelSize = queue.length - front;
        let level = [];
        for (let i = 0; i < levelSize; i++) {
            const node = queue[front++];
            if (node.left !== null)     queue.push(node.left);
            if (node.right !== null)    queue.push(node.right);
            level.push(node.val);
        }
        res.push(level);
    }
    return res;
};
