class Solution {
    public int findDuplicate(int[] nums) {
        //iterate through nums array
        //check to see if the abs(nums[nums[i] -1] < 0)
        //if so return that number
        //mark abs(nums[nums[i] -1] with -1 every iteration until the end of the array is reached or the duplicate is found. 

        for(int num : nums){ 
            int idx = Math.abs(num) - 1;
            if(nums[idx] < 0){
                return Math.abs(num);
            }
            nums[idx] *= -1;
        }
        return -1;
    }
}
