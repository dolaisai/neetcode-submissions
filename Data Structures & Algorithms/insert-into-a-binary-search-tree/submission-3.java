class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null){
            return new TreeNode(val);
        }
        DFS(root, val);
        return root; 
    }
    public void DFS(TreeNode root, int val){
        if(root.left == null && root.val > val){
            root.left = new TreeNode(val);
            return; 
        }
        else if(root.right == null && root.val < val){
            root.right = new TreeNode(val);
            return; 
        }
        if(root.val < val){
            DFS(root.right, val);
        }
        else{
            DFS(root.left, val);
        }
    }
}