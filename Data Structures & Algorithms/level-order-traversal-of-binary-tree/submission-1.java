class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<List<Integer>>();
        }


        Queue<TreeNode> queue = new LinkedList<>(); 
        List<List<Integer>> res = new ArrayList<>();

        queue.add(root); 

        while(queue.size() != 0){
            int size = queue.size(); 
            List<Integer> tmpList = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode tmp = queue.poll(); 
                
                tmpList.add(tmp.val);
                if(tmp.left != null){
                    queue.add(tmp.left);
                }
                if(tmp.right != null){
                    queue.add(tmp.right); 
                }
            }
            res.add(tmpList); 
        }
        return res; 
    }
}
