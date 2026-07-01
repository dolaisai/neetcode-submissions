class Solution {  
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        
        return dfs(root, subRoot); 
    }
    public boolean dfs(TreeNode root, TreeNode subRoot){
        if(root != null){
            if(root.val == subRoot.val && sameTree(root, subRoot)){
                return true; 
            }
            else{
                return dfs(root.left, subRoot) || dfs(root.right, subRoot);
            }
        }
        else{
            return false; 
        }
            
    }
    public boolean sameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) {
            return true;
        }
        if(p == null || q == null){ 
            return false;
        }
        if(p.val != q.val){
            return false;
        }

        return sameTree(p.left, q.left) && sameTree(p.right, q.right);
    }
}
