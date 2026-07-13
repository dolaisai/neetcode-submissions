class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> minH = new PriorityQueue<Integer>(); //default min heap

        for(int i : nums){
            minH.add(i);
            while(minH.size() > k){
                minH.poll();
            }
        }
        return minH.poll(); 
    }
}
