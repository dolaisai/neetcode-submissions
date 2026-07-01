class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int resIdx = 0;
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> deq = new ArrayDeque<>();

        if(nums.length == 1 && k == 1){
            return nums; 
        }
        
        for(int i = 0; i < k; i++){
            while(deq.size() > 0 && nums[i] > nums[deq.peekLast()]){
                deq.removeLast();
            }
            deq.addLast(i);
        }
        res[resIdx] = nums[deq.peekFirst()];
        resIdx++;

        int left = 0; 
        for(int right = k; right < nums.length; right++){
            if (!deq.isEmpty() && deq.peekFirst() <= right - k){
                deq.removeFirst();
            }
            while(deq.size() > 0 && nums[right] > nums[deq.peekLast()]){
                deq.removeLast();
            }
            deq.addLast(right);
            res[resIdx] = nums[deq.peekFirst()];
            resIdx++;
            left++;
        }
        return res; 
        
    }
}
