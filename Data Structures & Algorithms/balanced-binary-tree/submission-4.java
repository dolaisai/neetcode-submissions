class Solution {
    boolean balanced = true; 
    public boolean isBalanced(TreeNode root) {
        DFS(root);
        return balanced; 
    }
    public int DFS(TreeNode root){
        if(root != null){
            int leftRes = DFS(root.left); 
            int rightRes = DFS(root.right); 
            if(balanced){
                balanced = Math.abs(leftRes - rightRes) <= 1;
            }
            return Math.max(leftRes, rightRes) + 1;
        }
        else{
            return 0; 
        }
        

    }
}
