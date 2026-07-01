class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null){
            return new ArrayList<>(); 
        }
        queue.offer(root);
        List<Integer> res = new ArrayList<>();  

        while(!queue.isEmpty()){
            int size = queue.size(); 
             
            for(int i = 0; i < size - 1; i++){
                TreeNode tmp = queue.poll();
                if(tmp.left != null){
                    queue.offer(tmp.left); 
                }
                if(tmp.right != null){
                    queue.offer(tmp.right); 
                } 
            }
            TreeNode tmp = queue.poll();
            res.add(tmp.val); 
            if(tmp.left != null){
                queue.offer(tmp.left); 
            }
            if(tmp.right != null){
                queue.offer(tmp.right); 
            }
        }
        return res; 
    }
}
