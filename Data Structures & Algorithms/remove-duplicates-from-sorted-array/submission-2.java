class Solution {
    public int removeDuplicates(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        int nextValidPos = 1;

        for (int curr = 1; curr < nums.length; curr++) {

            if (nums[curr] != nums[curr - 1]) {
                nums[nextValidPos] = nums[curr];
                nextValidPos++;
            }
        }

        return nextValidPos;
    }
}