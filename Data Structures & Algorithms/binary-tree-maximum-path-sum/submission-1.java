class Solution {
    int globalMax = Integer.MIN_VALUE; 
    public int maxPathSum(TreeNode root) {
        dfs(root, Integer.MIN_VALUE);
        return globalMax; 
    }
    public int dfs(TreeNode root, int currSum){
        if(root == null){
            return 0; 
        }
        
        int leftSum = dfs(root.left, currSum);
        if(leftSum < 0){
            leftSum = 0;
        }
        int rightSum = dfs(root.right, currSum); 
        if(rightSum < 0){
            rightSum = 0;
        }

        globalMax = Math.max(globalMax, leftSum + rightSum + root.val);

        currSum = root.val + Math.max(leftSum, rightSum);

        return currSum; 
    }
}
