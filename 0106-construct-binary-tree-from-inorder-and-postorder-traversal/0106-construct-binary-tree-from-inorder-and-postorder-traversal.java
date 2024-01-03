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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || postorder == null || inorder.length != postorder.length)
            return null;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, map);
    }
    
    private TreeNode buildTree(int[] inorder, int istart, int iend, int[] postorder, int pstart, int pend, HashMap<Integer,Integer> map) {
        if(istart > iend || pstart > pend)
            return null;
        TreeNode root = new TreeNode(postorder[pend]);
        int inRoot = map.get(postorder[pend]);
        int numsLeft = inRoot - istart;
        root.left = buildTree(inorder, istart, inRoot - 1, postorder, pstart, pstart + numsLeft - 1, map);
        root.right = buildTree(inorder, inRoot + 1, iend, postorder, pstart + numsLeft, pend - 1, map);
        return root;
    } 
    
    
}