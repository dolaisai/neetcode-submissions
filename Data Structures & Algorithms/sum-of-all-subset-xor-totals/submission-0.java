class Solution {
    public int subsetXORSum(int[] nums) {
        return backtrack(nums, 0, 0);
         
    }
    public int backtrack(int[] nums, int i, int total){
        if(i == nums.length){
            return total; 
        }
        //include nums[i];
        return backtrack(nums, i + 1, total ^ nums[i]) + 
        backtrack(nums, i + 1, total);

    } 
}