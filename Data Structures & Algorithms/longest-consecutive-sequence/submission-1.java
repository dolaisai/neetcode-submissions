class Solution {
    public int longestConsecutive(int[] nums) {
        //use hashset for O(1) lookup and no duplicates
        HashSet<Integer> values = new HashSet<>();

        int globalMax = 0; 

        //populate hashset
        for(int i = 0; i < nums.length; i++){
            values.add(nums[i]);
        }

        //for each value is set,
            //check if val-1 is not in set. 
                //if not, start of seq. Move into checking val+1
        for (int val : values) {
            if (!values.contains(val - 1)) {
                int count = 1;
                while (values.contains(val + count)) {
                    count++;
                }
                globalMax = Math.max(globalMax, count);
            }
        }
        return globalMax;
    }   
}

