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
    int idx = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //call our helper function
        return helper(preorder, inorder, 0, preorder.length-1);

    }
    public TreeNode helper(int[] preorder,int[] inorder,int left,int right){
        //base case
        if(idx==preorder.length || left>right){
            return null;
        }

        //obeously the 0'th index of preorder array is our root
        TreeNode root = new TreeNode(preorder[idx]);

        //iterate the inorder array
        for(int i=left; i<=right;i++){
            //compare the iindex values between the two arrays
            if(preorder[idx]==inorder[i]){
                //increment the idx 
                idx++;

                //call recursion for left and right subtree 
                root.left = helper(preorder, inorder, left, i-1);
                root.right = helper(preorder, inorder, i+1, right);
                
                break;
            }
        }
        return root;
    }
}