class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null){
            return root2; 
        }   
        if(root2 == null){
            return root1; 
        }
        
        return DFS(root1, root2);
    }
    private TreeNode DFS(TreeNode node1, TreeNode node2) {
        if (node1 == null) {
            return node2;
        }

        if (node2 == null) {
            return node1;
        }

        TreeNode root = new TreeNode(node1.val + node2.val);

        root.left = DFS(node1.left, node2.left);
        root.right = DFS(node1.right, node2.right);

        return root;
    }
}