class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();

        if(root == null){
            return res; 
        }  

        queue.offer(root); 
        while(!queue.isEmpty()){
            int size = queue.size(); 
            List<Integer> sublist = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                sublist.add(node.val);
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right); 
                }
            }
            res.add(sublist);
        }
        return res; 
    }
}
