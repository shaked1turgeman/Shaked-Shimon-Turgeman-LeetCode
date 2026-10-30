package medium;

import common.TreeNode;
import java.util.ArrayList;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;
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
//  Time = Space = O(n)
public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null)  return res;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int levelSize = q.size();
            List<Integer> level = new ArrayList<>();
            while (levelSize > 0) {
                TreeNode curr = q.poll();
                level.add(curr.val);
                if(curr.left!=null)     q.offer(curr.left);
                if(curr.right!=null)     q.offer(curr.right);
                levelSize--;
            }
            res.add(level);
        }
        return res;
    }
}
