class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null){
            return false; 
        }
        return DFS(root, targetSum, 0);
    }
    public boolean DFS(TreeNode node, int target, int sum){
        if(node == null){
            return false; 
        }
        if(node.left == null && node.right == null){
            sum += node.val;
            return sum == target;
        }

        sum += node.val;
        return  DFS(node.left, target, sum) ||
                DFS(node.right, target, sum);
        



    }
}