class Solution {
    //solution 1 (Brute Force)
    public boolean hasDuplicate(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            int counter = 0;
            for(int j = 0; j < nums.length; j++){
                if(nums[i] == nums[j]){
                    counter++;
                }
            }
            if(counter >= 2){
                return true; 
            }
        }
        return false; 
    }
}