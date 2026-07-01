class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>(); 
        DFS(root, res);
        return res; 
    }
    public void DFS(TreeNode root, List<Integer> list){
        if(root == null){
            return;
        }
        DFS(root.left, list);
        list.add(root.val);
        DFS(root.right, list);
    }
}