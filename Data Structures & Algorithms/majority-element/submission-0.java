class Tuple {
    private int val; 
    private int freq;

    public Tuple(int val, int freq){
        this.val = val; 
        this.freq = freq; 
    }
}

class Solution {
    public int majorityElement(int[] nums) {
        Tuple majority = new Tuple(nums[0], 1);
        for(int i = 1; i < nums.length; i++){
            if(majority.val == nums[i]){
                majority.freq++;
            }
            else{
                majority.freq--;
            }
            //check to see
            if(majority.freq == 0){
                majority.val = nums[i];
                majority.freq = 1;
            }
        }
        return majority.val; 
    }
}