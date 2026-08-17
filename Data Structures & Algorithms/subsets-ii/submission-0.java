class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>(); 
        backtrack(nums, 0, new ArrayList(), res);
        return res; 
    }
    //backtracking alg
    public void backtrack(
        int[] nums, 
        int idx, 
        List<Integer> sub, 
        List<List<Integer>> res)
        {
        res.add(new ArrayList<>(sub));

        for (int i = idx; i < nums.length; i++) {

            if (i > idx && nums[i] == nums[i - 1]) {
                continue;
            }

            sub.add(nums[i]);

            backtrack(nums, i + 1, sub, res);

            sub.remove(sub.size() - 1);
        }
    }
}
