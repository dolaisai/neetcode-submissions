class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>(); 
        DFS(root, res); 
        return res; 
    }
    public void DFS(TreeNode root, List<Integer> res){
        if(root == null){
            return;
        }
        DFS(root.left, res); 
        DFS(root.right, res); 
        res.add(root.val);

        return;
    }
}