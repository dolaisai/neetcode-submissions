class Solution {
    public int majorityElement(int[] nums) {
        int majorityVal = nums[0];
        int majorityFreq = 1;
        for(int i = 1; i < nums.length; i++){
            if(majorityVal == nums[i]){
                majorityFreq++;
            }
            else{
                majorityFreq--;
            }
            if(majorityFreq == 0){
                majorityVal = nums[i];
                majorityFreq = 1;
            }
        }
        return majorityVal; 
    }
}