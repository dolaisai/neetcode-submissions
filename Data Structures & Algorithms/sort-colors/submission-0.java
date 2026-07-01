class Solution {
    public void sortColors(int[] nums) {
        //bucket sort
        int[] bucket = new int[]{0,0,0};

        for(int i = 0; i < nums.length; i++){
            bucket[nums[i]]++;
        }
        
        int idx = 0;
        for(int i = 0; i < bucket.length; i++){
            for(int j = bucket[i]; j > 0; j--){
                nums[idx] = i;
                idx++;
            }
        }
    }
}