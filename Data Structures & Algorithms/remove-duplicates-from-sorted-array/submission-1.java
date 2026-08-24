class Solution {
    public int removeDuplicates(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        int lastValid = 1;

        for (int ptr = 1; ptr < nums.length; ptr++) {

            if (nums[ptr] != nums[ptr - 1]) {
                nums[lastValid] = nums[ptr];
                lastValid++;
            }
        }

        return lastValid;
    }
}