class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        int left = 0;  
        int right = numbers.length - 1;

        while(numbers[left] + numbers[right] != target){
            if(numbers[left] + numbers[right] > target){
                right--;
            }
            else{
                left++;
            }
        }
        
        //fix indices since return value should be 1-indexed
        res[0] = left + 1; 
        res[1] = right + 1;
        return res;
    }
}
