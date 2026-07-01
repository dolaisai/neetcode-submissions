class Solution {
    public int[] getConcatenation(int[] nums) {
        int len = nums.length;
        int[] res = new int[len * 2];
        for(int i = 0; i < nums.length; i++){
            res[i] = nums[i];
            res[i + len] = nums[i];
        }
        return res; 
    }
}