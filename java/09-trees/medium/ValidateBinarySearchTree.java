package medium;

import common.TreeNode;
import java.util.Deque;
import java.util.ArrayDeque;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
//  Time = O(n)   ,   Space = O(h)
public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        if(root==null) return true;
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode curr = root, prev=null;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr=stack.pop();
            if(prev!=null && curr.val<=prev.val) return false;
            prev = curr;
            curr = curr.right;
        }
        return true;
    }
}
