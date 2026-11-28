// Time: O(h + k)   ,   Space: O(h)
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
 * @param {number} k
 * @return {number}
 */
var kthSmallest = function(root, k) {
    function inorder(node) {
        if (node === null) return null;
        const leftResult = inorder(node.left);
        if (leftResult !== null) return leftResult;
        k--;
        if (k === 0) return node.val;
        const rightResult = inorder(node.right);
        if (rightResult !== null) return rightResult;
        return null;
    }

    return inorder(root);
};
