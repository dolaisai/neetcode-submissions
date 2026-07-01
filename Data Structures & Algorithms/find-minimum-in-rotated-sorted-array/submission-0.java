class Solution {
    public int findMin(int[] nums) {
        //setup left and right pointers. 
        //use binary search with left right and a calculated midpoint. 
            //check to see if mid is >= to left pointer. 
                //mid is a part of left part of array. 
                ////save current min value at mid
                //check right. 
            //else
                ////save current min value at mid
                //check left

            int left = 0; 
            int right = nums.length - 1;
            int globalMin = nums[0];

            while(left <= right){
                if(nums[left] < nums[right]){
                    globalMin = Math.min(globalMin, nums[left]);
                    break;
                }

                int mid = left + (right - left) / 2; 
                globalMin = Math.min(globalMin, nums[mid]);
                if(nums[mid] >= nums[left]){
                    left = mid + 1; 
                }
                else{
                    right = mid - 1; 
                }
            }
            return globalMin;  
    }
}
