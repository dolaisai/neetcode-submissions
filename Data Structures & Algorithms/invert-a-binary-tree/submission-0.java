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
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return root; 
        }
        dfs(root);
        return root; 
    }
    public void dfs(TreeNode root){
        if(root.left == null && root.right == null){
            return; 
        }
        TreeNode tmp = root.left; 
        root.left = root.right; 
        root.right = tmp; 
        if(root.left == null && root.right != null){
            invertTree(root.right); 
        }
        else if(root.right == null && root.left != null){
            invertTree(root.left);
        }
        else{
            invertTree(root.left);
            invertTree(root.right);
        }
    }
}
