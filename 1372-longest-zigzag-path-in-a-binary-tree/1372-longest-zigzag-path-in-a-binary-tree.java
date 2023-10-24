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
    public int longestZigZag(TreeNode root) {
        if(root == null)
            return 0;
        int leftPath = helper(root.left, 1, true);
        int rightPath = helper(root.right, 1, false);
        return Math.max(leftPath, rightPath);
    }
    
    public int helper(TreeNode root, int count, boolean isLeft) {
        if(root == null)
            return count = count - 1;
        int leftPath = 0;
        int rightPath = 0;
        if(isLeft) {
            leftPath = helper(root.left, 1, true);
            rightPath = helper(root.right, count + 1, false);
        } else {
            leftPath = helper(root.left, count + 1, true);
            rightPath = helper(root.right, 1, false);
        }
        return Math.max(leftPath, rightPath);
    }
}