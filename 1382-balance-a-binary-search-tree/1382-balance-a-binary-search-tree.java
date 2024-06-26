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
    List<TreeNode> list = new ArrayList<>();
    public TreeNode balanceBST(TreeNode root) {
        inorder(root);
        return balanceTree(0, list.size() - 1);
    }
    
    public void inorder(TreeNode root) {
        if(root == null)
            return;
        inorder(root.left);
        list.add(root);
        inorder(root.right);
    }
    public TreeNode balanceTree(int start, int end) {
        if(start > end)
            return null;
        int mid = (start + end) / 2;
        TreeNode root = list.get(mid);
        root.left = balanceTree(start, mid - 1);
        root.right = balanceTree(mid + 1, end);
        return root;
    }
}