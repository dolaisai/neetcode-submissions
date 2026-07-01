class Solution {
    int goodNodes = 0; 
    public int goodNodes(TreeNode root) {
        dfs(root, Integer.MIN_VALUE);
        return goodNodes; 
    }
    public void dfs(TreeNode root, int maxSoFar){
        if(root == null){
            return;
        }
        if(root.val >= maxSoFar){
            goodNodes++;
        }
        dfs(root.left, Math.max(maxSoFar, root.val));
        dfs(root.right, Math.max(maxSoFar, root.val)); 
        return; 
    }
}
