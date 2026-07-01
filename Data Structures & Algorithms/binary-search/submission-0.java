class Solution {
    public int search(int[] nums, int target) {
        //setup left and right pointers at end of array 
        //setup mid pointer that points to (r + l) / 2
        //while left <= right (equals?)
            //check mid against target.
            //elseif mid < target
                //change right to mid - 1
            //else 
                //change left to mid + 1;

        //edgecases: 
            //nums has length 1, check if ele is target else return -1

        int left = 0; 
        int right = nums.length - 1;

        if(nums.length == 1 && nums[0] == target){
            return 0; 
        }
        while(left <= right){
            int mid = (right + left) / 2;
            if(nums[mid] == target){
                return mid; 
            }
            else if(nums[mid] < target){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        return -1;
    }
}
