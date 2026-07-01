class Solution {
    public int[] sortArray(int[] nums) {
        Queue<Integer> minHeap = new PriorityQueue<>(); 
        for(int n : nums){
            minHeap.add(n);
        }
        int idx = 0; 
        while(!minHeap.isEmpty()){
            int val = minHeap.poll(); 
            nums[idx] = val; 
            idx++;
        }

        return nums; 
    }
}