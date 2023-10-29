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
        int left = dfs(root.left, 1, true);
        int right = dfs(root.right, 1, false);
        return Math.max(left, right);
    }
    
    public int dfs(TreeNode root, int cnt, boolean isLeft) {
        if(root == null)
            return cnt = cnt - 1;
        int leftPath = 0;
        int rightPath = 0;
        if(isLeft) {
            leftPath = dfs(root.left, 1, true);
            rightPath = dfs(root.right, cnt + 1, false);
        } else {
            leftPath = dfs(root.left, cnt + 1, true);
            rightPath = dfs(root.right, 1, false);
        }
        return Math.max(leftPath, rightPath);
    }
}