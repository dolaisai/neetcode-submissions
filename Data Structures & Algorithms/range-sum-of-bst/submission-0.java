class Solution {
    int sum = 0; 
    public int rangeSumBST(TreeNode root, int low, int high) {
        //DFS 
        //basecase: if node is null, return sum.
        //if node's val is withing range low <= val <= high, sum += val
        //pass acc along with recursive calls
        DFS(root, low, high);
        return sum; 
    }
    public void DFS(TreeNode node, int low, int high){
        if(node == null){
            return; 
        }
        if(node.val >= low && node.val <= high){
            sum += node.val;
        }
        DFS(node.left, low, high);
        DFS(node.right, low, high); 
        return; 
    }
}