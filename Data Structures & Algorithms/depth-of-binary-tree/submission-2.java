class Solution {
    public int maxDepth(TreeNode root) {
        return DFS(root, 0);
    }

    public int DFS(TreeNode node, int depth){
        if(node == null){
            return depth; 
        }
        int leftDepth = DFS(node.left, depth + 1);
        int rightDepth = DFS(node.right, depth + 1);

        return Math.max(leftDepth, rightDepth);
    }
}
