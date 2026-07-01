public class Tuple {
    private int freq; 
    private int downtime;

    public Tuple(int freq, int downtime){
        this.freq = freq; 
        this.downtime = downtime; 
    } 
}

class Solution {
    public int leastInterval(char[] tasks, int n) {
        //get freq of each char by putting them into a hashmap with key = char and val = freq. 
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : tasks){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        //create and add frequencies for each key in map to maxHeap. 
        Queue<Integer> maxHeap = new PriorityQueue<>((a,b) -> (Integer.compare(b,a)));
        for(Character c : map.keySet()){
            maxHeap.add(map.get(c));
        }

        int time = 0; 
        Queue<Tuple> queue = new LinkedList<>();

        while(!maxHeap.isEmpty() || !queue.isEmpty()){
            time += 1;

            if(!maxHeap.isEmpty()){
                int freq = maxHeap.poll() - 1;
                if(freq != 0){
                    queue.add(new Tuple(freq, time + n));
                }
            }
            if(!queue.isEmpty() && queue.peek().downtime == time){
                Tuple tmp = queue.poll();
                maxHeap.add(tmp.freq);
            }
        }

        return time; 
        
    }
}
