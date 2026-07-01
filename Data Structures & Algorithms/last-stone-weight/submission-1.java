class Solution {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));

        for(int s : stones){
            maxHeap.offer(s);
        }
        while(maxHeap.size() != 1){
            int stoneA = maxHeap.poll(); 
            int stoneB = maxHeap.poll(); 

            if(stoneA == stoneB){
                maxHeap.offer(0); 
            }
            if(stoneA > stoneB){
                maxHeap.offer(stoneA - stoneB);
            }
        }
        return maxHeap.poll(); 
    }
}
