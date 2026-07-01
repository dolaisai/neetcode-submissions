class Solution {
    public int rob(TreeNode root) {
        //DFS
        //return pair of values [maxValwithRoot, maxValwithoutRoot]
        Tuple res = DFS(root);

        return Math.max(res.withRoot, res.withoutRoot);
    }

    public Tuple DFS(TreeNode node){
        if(node == null){
        return new Tuple(0,0);
        }
        Tuple leftRes = DFS(node.left);
        Tuple rightRes = DFS(node.right); 

        Tuple res = new Tuple(0,0); 

        res.withRoot = node.val + leftRes.withoutRoot + rightRes.withoutRoot; 
        res.withoutRoot =   Math.max(leftRes.withRoot, leftRes.withoutRoot) + 
                            Math.max(rightRes.withRoot, rightRes.withoutRoot); 

        return res;
    }
}

public class Tuple{
    private int withRoot;
    private int withoutRoot; 

    public Tuple(int withRoot, int withoutRoot){
        this.withRoot = withRoot; 
        this.withoutRoot = withoutRoot; 
    }
}