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
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0; 
        }
        int depth = 1; 
        return dfs(root, depth);
    }
    public int dfs(TreeNode root, int depth){
        int leftDepth = depth; 
        int rightDepth = depth;
        if(root.left != null && root.right != null){
            leftDepth = Math.max(depth, dfs(root.right, depth + 1));
            rightDepth = Math.max(depth, dfs(root.left, depth + 1));
        }
        if(root.left == null && root.right != null){
            leftDepth = Math.max(depth, dfs(root.right, depth + 1));
        }
        if(root.right == null && root.left != null){
            rightDepth = Math.max(depth, dfs(root.left, depth + 1));
        }
        return Math.max(leftDepth, rightDepth);
    }
}
