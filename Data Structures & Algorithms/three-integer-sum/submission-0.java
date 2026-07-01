class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int[] sorted = nums;
        Arrays.sort(sorted);
        List<List<Integer>> res = new ArrayList();

        for(int i = 0; i < sorted.length; i++){
            if(i > 0 && sorted[i] == sorted[i-1]) {
                continue;
            }

            int target = sorted[i] * -1;
            int left = i + 1;
            int right = sorted.length - 1;

            while(left < right){
                if(target < sorted[left] + sorted[right] ){
                    right--;
                }
                else if(target > sorted[left] + sorted[right]){
                    left++;
                }
                else {
                    res.add(Arrays.asList(sorted[i], sorted[left], sorted[right]));
                    left++;
                    while(sorted[left] == sorted[left - 1] && left < right){
                        left++;
                    }
                }
            }
        }

        return res;
    }
}