class Solution {
    public int kthSmallest(TreeNode root, int k) {
        if(root == null){
            return 0; 
        }
        List<Integer> ordVals = new ArrayList<>(); 
        TreeNode curr = root; 
        Stack<TreeNode> stack = new Stack<>(); 
        stack.push(curr); 
        curr = curr.left; 

        while(!stack.isEmpty() || curr != null){
            while(curr != null){
                stack.push(curr); 
                curr = curr.left; 
            }
            curr = stack.pop(); 
            ordVals.add(curr.val);
            k--;
            if(k == 0){
                break; 
            }
            curr = curr.right; 
        }
        for(Integer i : ordVals){
            System.out.println(i);
        }
        return ordVals.get(ordVals.size() - 1);
    }
}
