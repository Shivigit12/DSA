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
    int count = 0;
    public int longestZigZag(TreeNode root) {
        int left = zigzag(root.left, 1, true);
        int right = zigzag(root.right, 1, false);
        return Math.max(left, right);
    }
    
    public int zigzag(TreeNode root, int count, boolean isLeft) {
        if(root == null)
            return count = count - 1;
        int left = 0;
        int right = 0;
        if(isLeft) {
            left = zigzag(root.left, 1, true);
            right = zigzag(root.right, count + 1, false);
        } else {
            left = zigzag(root.left, count + 1, true);
            right = zigzag(root.right, 1, false);
        }
        return Math.max(left, right);
    }
}