class Solution { 
    public int goodNodes(TreeNode root) {
       
        return  dfs(root, root.val); 
    }
    public int dfs(TreeNode root, int maxSoFar){
        if(root == null){
            return 0;
        }
        int goodNodes = 0;
        if(root.val >= maxSoFar){
            goodNodes = 1;
            maxSoFar = root.val;
        }
        
        return goodNodes + dfs(root.left, maxSoFar) 
        + dfs(root.right, maxSoFar); 
    }
}