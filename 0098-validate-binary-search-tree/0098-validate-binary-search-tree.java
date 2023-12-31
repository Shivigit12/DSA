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
    public boolean isValidBST(TreeNode root) {
        return checkBST(root, null, null);       
    }
    
    public boolean checkBST(TreeNode root, TreeNode left, TreeNode right) {
        if(root == null){
            return true;
        }
        else if(left != null && root.val <= left.val)
            return false;
        else if(right != null && root.val >= right.val)
            return false;
        
        return checkBST(root.left, left, root) && checkBST(root.right, root, right);
    }
}