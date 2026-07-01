class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //binary search the rows to find the correct range that the target is in 
        //once the row is found, call helper method to binary search the row and return the target index. 

        int left = 0; 
        int right = matrix.length - 1; 
        int[] targetRow = new int[matrix[0].length]; 
        if(matrix.length == 1){
            return BS(matrix[0], target);
        }

        while(left <= right){
            int mid = left + (right - left) / 2; 
            if(matrix[mid][0] <= target && matrix[mid][matrix[mid].length - 1] >= target){
                return BS(matrix[mid], target); 
            }
            else if(matrix[mid][0] >= target){
                right = mid - 1;
            }
            else if(matrix[mid][matrix[mid].length - 1] <= target){
                left = mid + 1; 
            }
        }
        return false; 
        
    }
    public boolean BS(int[] row, int target){
        int left = 0; 
        int right = row.length - 1;

        while(left <= right){
            int mid = left + (right - left) / 2; 

            if(row[mid] == target){
                return true; 
            }
            else if(row[mid] < target){
                left = mid + 1; 
            }
            else right = mid - 1; 
        }
        return false; 
    }
}
