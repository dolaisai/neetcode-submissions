class Solution {
    public int minimumDifference(int[] nums, int k) {
        //build up sliding window to k size and save into global min. 
        //iterate through nums until right hits the end of the array. 
            //compute the abs val of the difference and compare it to currently saved min. 
            //repeat until end. 
        //return min

        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        
        int left = 0; 
        for(int right = k - 1; right < nums.length; right++){
            int diff = Math.abs(nums[right] - nums[left]);
            min = Math.min(min, diff);
            left++;
        }
        return min;
        
    }
}