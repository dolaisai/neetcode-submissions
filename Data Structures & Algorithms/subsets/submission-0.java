class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>(); 

        backtrack(0, nums, new ArrayList<Integer>(), res);
        return res; 
    }
    public void backtrack(int index, int[] nums, List<Integer> sublist, List<List<Integer>> res){
        if(index >= nums.length){ 
            res.add(new ArrayList(sublist));
            return; 
        }
        sublist.add(nums[index]);
        backtrack(index + 1, nums, sublist, res);
        sublist.remove(sublist.size() - 1);
        backtrack(index + 1, nums, sublist, res);
        return; 
    }
}
