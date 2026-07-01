class Solution {
    public int trap(int[] height) {
        int[] prefix = new int[height.length];
        int[] suffix = new int[height.length];

        //calc prefix maxes
        int max = 0;
        for(int i = 0; i < height.length; i++){
            if(i == 0){
                max = height[0];
            }
            else{
                max = Math.max(max, height[i]);
            }
            prefix[i] = max;
        }

        //calc suffix maxes
        max = 0;
        for(int i = height.length - 1; i >= 0; i--){
            if(i == height.length - 1){
                max = height[height.length - 1];
            }
            else{
                max = Math.max(max, height[i]);
            }
            suffix[i] = max;
        }

        int res = 0;
        for(int i = 0; i < height.length; i++){
            int totalWater = Math.min(prefix[i], suffix[i]) - height[i];
            res += totalWater;
        }

        return res;
    }

    
}
