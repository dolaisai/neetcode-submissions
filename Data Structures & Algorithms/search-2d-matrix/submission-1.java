class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //use binary search to check the first indices of the rows (find region)
            //if matrix[mid][0] <= target && matrix[mid][len] >= target return mid array.
            //else if matrix[mid][len] < 
        //once region is found. call binary search helper function, passing in the inner array and the target.
        int left = 0; 
        int right = matrix.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2; 
            if(matrix[mid][0] <= target && matrix[mid][matrix[mid].length - 1] >= target){
                return binarySearchInner(matrix[mid], target);
            }
            else if(matrix[mid][0] < target && matrix[mid][matrix[mid].length - 1] < target){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        return false; 
    }
    public boolean binarySearchInner(int[] nums, int target){
        int left = 0; 
        int right = nums.length - 1;
        if(nums.length == 1 && nums[0] == target){
            return true; 
        }
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){
                return true; 
            }
            else if(nums[mid] < target){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        return false;
    }
}
