class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return DFS(root, p, q);
    }

    public TreeNode DFS(TreeNode root, TreeNode p, TreeNode q){
        if(root == null){
            return null; 
        }
        if(root.val == p.val || root.val == q.val){
            return root; 
        }

        TreeNode leftRes = DFS(root.left, p, q);
        TreeNode rightRes = DFS(root.right, p, q);

        if(leftRes != null && rightRes != null){
            return root; 
        }
        else if(leftRes != null){
            return leftRes;
        }
        else{
            return rightRes; 
        }
    }
}