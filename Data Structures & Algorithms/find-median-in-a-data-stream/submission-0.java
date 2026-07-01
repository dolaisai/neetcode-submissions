class MedianFinder {
    private Queue<Integer> minHeap;
    private Queue<Integer> maxHeap;  

    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(b,a));
    }
    
    public void addNum(int num) {
        if (minHeap.isEmpty()) {
            minHeap.add(num);
        } else if (num >= minHeap.peek()) {
            minHeap.add(num);
        } else {
            maxHeap.add(num);
        }
        if(Math.abs(minHeap.size() - maxHeap.size()) >= 2){
            if(minHeap.size() > maxHeap.size()){
                maxHeap.add(minHeap.poll());
            }
            else{
                minHeap.add(maxHeap.poll());
            }
        }
    }
    
    public double findMedian() {
        if((minHeap.size() + maxHeap.size()) % 2 == 0){
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        }
        else if(minHeap.size() > maxHeap.size()){
            return (double)minHeap.peek(); 
        }
        else{
            return (double)maxHeap.peek(); 
        }
    }
}
