class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return DFS(root, 0, targetSum);
    }
    public boolean DFS(TreeNode node, int sum, int targetSum) {
        if (node == null) {
            return false;
        }

        sum += node.val;

        if (node.left == null && node.right == null) {
            return sum == targetSum;
        }

        return DFS(node.left, sum, targetSum)
            || DFS(node.right, sum, targetSum);
    }
}