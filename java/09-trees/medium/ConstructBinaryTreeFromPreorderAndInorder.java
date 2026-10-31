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
*            Constraints:
*   1)  1 <= preorder.length <= 3000
*   2)  inorder.length == preorder.length
*   3)  -3000 <= preorder[i], inorder[i] <= 3000
*   4)  preorder and inorder consist of unique values.
*   5)  Each value of inorder also appears in preorder.
*   6)  preorder is guaranteed to be the preorder traversal of the tree.
*   7)  inorder is guaranteed to be the inorder traversal of the tree.
*/
// Time = O(n)   ,   Space = O(n)
public class ConstructBinaryTreeFromPreorderAndInorder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode head=null, prev=null;
        int index=0;
        for(int i=0; i<preorder.length; i++){
            TreeNode temp = new TreeNode(preorder[i]);
            if(i==0) head=temp;
            else if(!stack.isEmpty()  &&  stack.peek().val != inorder[index])
                stack.peek().left=temp;
            else{
                while(!stack.isEmpty()  &&  stack.peek().val == inorder[index]){
                        prev=stack.pop();
                        index++;
                }    
                prev.right=temp;    
            }
            stack.push(temp);
        }
        return head;
    }
}
