class KthLargest {
    private Queue<Integer> minHeap = new PriorityQueue();
    private int k; 

    public KthLargest(int k, int[] nums) {
        this.k = k; 
        for(int i : nums){
            minHeap.add(i);
        }
        while(minHeap.size() > k){
            minHeap.poll(); 
        }
    }
    
    public int add(int val) { 
        minHeap.add(val);
        if(minHeap.size() > k){
            minHeap.poll(); 
        }
        return minHeap.peek(); 
    }
}
