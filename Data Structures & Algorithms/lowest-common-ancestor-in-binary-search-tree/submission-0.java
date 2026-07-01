class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode low;
        TreeNode high;
        if(p.val < q.val){
            low = p; 
            high = q;
        }
        else{
            high = p; 
            low = q;
        }
        
        return lca(root, low, high);
    }
    public TreeNode lca(TreeNode root, TreeNode low, TreeNode high){
        //if either node.val == root.val 
        if(low.val == root.val || high.val == root.val){
            return root; 
        }
        //if both nodes are less than root.val
        else if(low.val < root.val && high.val < root.val){
            return lca(root.left, low, high);
        }
        //if both nodes are greater than root.val
        else if(low.val > root.val && high.val > root.val){
            return lca(root.right, low, high);
        }
        else{
            return root; 
        }
        
         
    }
}
