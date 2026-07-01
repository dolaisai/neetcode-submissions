class Solution {
    public int searchInsert(int[] nums, int target) {
        //binary search
        int potentialTarget = -1; 
        int left = 0; int right = nums.length - 1; 
        while(left <= right){
            potentialTarget = left + (right - left) / 2;
            System.out.println(potentialTarget);
            if(nums[potentialTarget] == target){
                return potentialTarget;
            }
            else if(nums[potentialTarget] < target){
                left = potentialTarget + 1;
            }
            else{
                right = potentialTarget - 1; 
            }
        }
        return left; 
    }
}