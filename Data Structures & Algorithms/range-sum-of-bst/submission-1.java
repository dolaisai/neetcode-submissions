class Solution { 
    public int rangeSumBST(TreeNode root, int low, int high) {
        //DFS 
        //basecase: if node is null, return sum.
        //if node's val is withing range low <= val <= high, sum += val
        //pass acc along with recursive calls
        
        return DFS(root, low, high); 
    }
    public int DFS(TreeNode node, int low, int high){
        if(node == null){
            return 0; 
        }

        int sum = 0; 

        if(node.val >= low && node.val <= high){
            sum += node.val;
        }
        sum += DFS(node.left, low, high);
        sum += DFS(node.right, low, high); 
        return sum; 
    }
}