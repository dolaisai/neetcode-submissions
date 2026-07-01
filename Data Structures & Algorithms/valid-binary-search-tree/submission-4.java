class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return false; 
        }
        return  dfs(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    public boolean dfs(TreeNode root, int minRange, int maxRange){
        if(root == null){
            return true;
        }
        if(root.val <= minRange || root.val >= maxRange){
            return false; 
        }
        
        boolean leftRes = dfs(root.left, minRange, root.val);
        boolean rightRes = dfs(root.right, root.val, maxRange);

        return leftRes && rightRes; 
    }
}
