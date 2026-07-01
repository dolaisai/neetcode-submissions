class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet(); 
        if(nums.length == 1){
            return false; 
        }
        for(int num : nums){
            if(!set.contains(num)){
                set.add(num);
            }
            else{
                return true;
            }
        }
        return false; 
    }
}