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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> sumList = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null)
            return sumList;
        q.add(root);
        while(!q.isEmpty()) {
            double sum = 0;
            double length = q.size();
            for(int i = 0; i < length; i++) {
                TreeNode node = q.poll();
                sum = sum + node.val;
                if(node.left != null)
                    q.offer(node.left);
                if(node.right != null)
                    q.offer(node.right);
            }
            sumList.add(sum / length);
        }
        return sumList;
    }
}