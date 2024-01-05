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
class Solution {
    int minDiff = Integer.MAX_VALUE;
    int prev = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        getMinimum(root);
        return minDiff;
    }
    
    public void getMinimum(TreeNode root) {
        if(root.left != null)
            getMinimum(root.left);
        minDiff = Math.min(minDiff, Math.abs(root.val - prev));
        prev = root.val;
        if(root.right != null)
            getMinimum(root.right);
    }
}