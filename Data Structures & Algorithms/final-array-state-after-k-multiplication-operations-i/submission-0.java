class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<Tuple> minH = new PriorityQueue<>((a, b) -> {
            if (a.val != b.val) {
                return Integer.compare(a.val, b.val);
            }
                return Integer.compare(a.index, b.index);
            });

        for(int i = 0; i < nums.length; i++){
            Tuple tmp = new Tuple(nums[i], i);
            minH.offer(tmp);
        }

        for(int i = 0; i < k; i++){
            Tuple tmp = minH.poll(); 
            tmp.val = tmp.val * multiplier; 
            nums[tmp.index] = tmp.val; 
            minH.offer(tmp);
        }

        return nums; 
    }
}

public class Tuple{
    private int val; 
    private int index; 

    public Tuple(int val, int index){
        this.val = val; 
        this.index = index; 
    }
}