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
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null)
            return 0;
        int h1 = height(root.left);
        int h2 = height(root.right);
        int lDiameter = diameterOfBinaryTree(root.left);
        int rDiameter = diameterOfBinaryTree(root.right);
        
        return Math.max(h1 + h2, Math.max(lDiameter, rDiameter));
    }
    
    int height(TreeNode root) {
        if(root == null)
            return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }
}