class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // iterate through array. FOR
        //if stack is empty push index of temps[0]; 
        //while top index of stacks value in temps > temps[i]
            //pop value and assign to local var. 
            //resultarray[popped index] = (i - poped index)
        //otherwise push index onto stack. 

        Stack<Integer> indexStack = new Stack(); 
        int[] res = new int[temperatures.length]; 

        for(int i = 0; i < res.length; i++){
            while(!indexStack.empty() && temperatures[indexStack.peek()] < temperatures[i]){
                int prevIndex = indexStack.pop(); 
                res[prevIndex] = (i - prevIndex);
            }
            indexStack.push(i);
        }

        return res;
    }
}
