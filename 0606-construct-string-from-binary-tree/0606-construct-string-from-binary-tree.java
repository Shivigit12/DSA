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
    StringBuilder sb = new StringBuilder();
    public String tree2str(TreeNode root) {
        treeToString(root);
        return sb.toString();
    }
    
    public void treeToString(TreeNode root) {
        if(root == null)
            return;
        if(root.left == null && root.right == null) {
            sb.append(root.val);
            return;
        }
        sb.append(root.val);
        sb.append("(");
        treeToString(root.left);
        sb.append(")");
        if(root.right != null) {
            sb.append("(");
            treeToString(root.right);
            sb.append(")");
        }
        return;
    }
}