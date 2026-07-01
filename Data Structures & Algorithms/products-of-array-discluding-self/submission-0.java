class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];

        //set first index of res to 0
        res[0] = 1;
        //iterate through L -> R and save products into res
        for(int i = 1; i < nums.length; i++){
            res[i] = res[i-1] * nums[i-1];
        }

        //setup suffix var and set val to 1
        int suffix = 1; 
        //iterate through R -> L and save products into res
        for(int i = res.length - 1; i >=0; i--){
            res[i] *= suffix;
            suffix *= nums[i];
        }
        return res;
    }
}  
