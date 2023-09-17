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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list;
        int h = height(root);
        for(int i = 1; i <= h; i++) {
            list = new ArrayList<>();
            if(i % 2 == 0) 
                levelOrderRightTraversal(root, i, list);
            else
                levelOrderLeftTraversal(root, i, list);
            res.add(list);
        }
        return res;
    }
    public void levelOrderLeftTraversal(TreeNode root, int i, List<Integer> list) {
        if(root == null)
            return;
        else if(i == 1)
            list.add(root.val);
        else if(i > 1) {
            levelOrderLeftTraversal(root.left, i - 1, list);
            levelOrderLeftTraversal(root.right, i - 1, list);
        }
    }
    public void levelOrderRightTraversal(TreeNode root, int i, List<Integer> list) {
        if(root == null)
            return;
        else if(i == 1)
            list.add(root.val);
        else if(i > 1) {
            levelOrderRightTraversal(root.right, i - 1, list);
            levelOrderRightTraversal(root.left, i - 1, list);
        }
    }
    public int height(TreeNode root) {
        if(root == null)
            return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }
}