class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));

        for(int i : gifts){
            pq.offer(i);
        }
        
        int i = 0; 

        while(i < k && !pq.isEmpty()){
            int num = pq.poll(); 
            num = (int)Math.floor(Math.sqrt(num));
            pq.offer(num);
            i++;
        }

        int remain = 0; 
        while(!pq.isEmpty()){
            int num = pq.poll(); 
            remain += num;
        }
        return remain; 
    }
}