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
        Queue<TreeNode> q = new LinkedList<>();
        List<Double> res = new ArrayList<>();
        if(root == null)
            return res;
        q.add(root);
        while(!q.isEmpty()) {
            double qlen = q.size();
            double row = 0;
            for(int i = 0; i < qlen; i++) {
                TreeNode curr = q.poll();
                row = row + curr.val;
                if(curr.left != null)
                    q.add(curr.left);
                if(curr.right != null)
                    q.add(curr.right);
            }
            res.add(row / qlen);
            
        }
        return res;
        
        
    }
}