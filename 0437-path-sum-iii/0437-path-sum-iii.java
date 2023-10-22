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
    int count;
    
    public int pathSum(TreeNode root, int targetSum) {
        count= 0;
        
        List<Integer> l1= new ArrayList<>();
        preorder(root, targetSum, 0, l1);
        
        return count;
    }
    
    public void preorder(TreeNode root, int targetSum, long temp, List<Integer> l1){
        if(root == null){
            return;
        }
        
        // temp+= root.val;
        l1.add(root.val);
        
        preorder(root.left, targetSum, temp, l1);
        preorder(root.right, targetSum, temp, l1);

        for(int i= l1.size()-1; i>=0; i--){
            temp+= l1.get(i);
            
            if(temp == targetSum){
                count++;
            }
        }
        
        //  Backtracking (restoring the previous condition)
        l1.remove(l1.size()-1);
    }
}