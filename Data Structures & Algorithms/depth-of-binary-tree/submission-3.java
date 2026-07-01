class Solution {
    public int maxDepth(TreeNode root) {
        return DFS(root,0); 
    }
    public int DFS(TreeNode node, int acc){
        if(node == null){
            return acc;
        }
        int leftRes = DFS(node.left, acc + 1);
        int rightRes = DFS(node.right, acc + 1);

        return Math.max(leftRes, rightRes);
    }
}
