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

// Time = O(n)   ,   Space = O(log(n))
public class ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        return divideAndConquer(nums,0,nums.length-1);
    }

     private TreeNode divideAndConquer(int[] nums, int left, int right){
        if(left>right) return null;
        int mid = left + (right - left) / 2;
        TreeNode x = new TreeNode(nums[mid]);
        x.left=divideAndConquer(nums,left,mid-1);
        x.right=divideAndConquer(nums,mid+1,right);
        return x;
    }
}

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
