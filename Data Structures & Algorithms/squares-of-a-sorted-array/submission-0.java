class Solution {
    public int[] sortedSquares(int[] nums) {
        PriorityQueue<Integer> minH = new PriorityQueue<>(); 
        for(int i : nums){
            minH.offer(i * i);
        }
        int[] res = new int[nums.length];
        int idx = 0; 
        while(!minH.isEmpty()){
            int i = minH.poll(); 
            res[idx] = i;
            idx++;
        }
        return res; 
    }
}