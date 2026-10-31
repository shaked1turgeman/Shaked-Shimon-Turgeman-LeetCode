package medium;

import common.TreeNode;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//  Time = O(n)   ,   Space = O(h)
public class LowestCommonAncestorOfBinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)    return null;
        else if (root==p)   return p;
        else if(root==q)    return q;
        else{
            TreeNode left=lowestCommonAncestor(root.left,p,q);
            TreeNode right=lowestCommonAncestor(root.right,p,q);
            if(left==null && right==null)   return null;
            else if(left!=null && right==null)   return left;
            else if(left==null && right!=null)  return right;
            else return root;
        }
    }
}
