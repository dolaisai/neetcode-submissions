class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        if(temperatures.length == 1){
            res[0] = 0;
            return res; 
        }
        Stack<Integer> stack = new Stack<>(); 
        stack.push(0);
        for(int i = 1; i < temperatures.length; i++){
            while(!stack.empty() && temperatures[i] > temperatures[stack.peek()]){
                res[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }
        while(!stack.empty()){
            res[stack.pop()] = 0;
        }
        return res; 
    }
}
