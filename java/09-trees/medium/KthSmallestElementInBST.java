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
// Time = O(h+k)   ,   Space = O(h)
public class KthSmallestElementInBST {
    public int kthSmallest(TreeNode root, int k) {
        TreeNode curr=root;
        Deque<TreeNode> stack = new ArrayDeque<>();
        while((curr!=null  || !stack.isEmpty()) && k!=0){
            while(curr!=null){
                stack.push(curr);
                curr=curr.left;
            }
            curr=stack.pop();
            k--;
            if (k == 0) return curr.val;
            curr = curr.right;
        }
        throw new IllegalArgumentException("Invalid k or empty tree");
    }
}
