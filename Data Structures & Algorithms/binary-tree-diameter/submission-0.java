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
    int res = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return res; 
    }
    public int dfs(TreeNode node){
        if(node != null){
            int leftH = dfs(node.left);
            int rightH = dfs(node.right);

            res = Math.max(res, leftH + rightH);

            return Math.max(leftH , rightH) + 1;
        }else{
            return 0;
        }
    }
}
