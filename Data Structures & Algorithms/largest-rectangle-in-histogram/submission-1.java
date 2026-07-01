class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<int[]> stack = new Stack();
        int globalMax = 0; 

        for(int i = 0; i < heights.length; i++){
            int startIndex = i;
            while(!stack.empty() && stack.peek()[1] > heights[i]){
                int[] popped = stack.pop(); 
                int pindex = popped[0];
                int pheight = popped[1];
                globalMax = Math.max(globalMax, pheight * (i - pindex));
                startIndex = pindex; 
            }
            stack.push(new int[]{startIndex, heights[i]});
        }

        for(int[] indHei : stack) {
            int ind = indHei[0];
            int hei = indHei[1];
            globalMax = Math.max(globalMax, hei * (heights.length - ind));
        }
        
        return globalMax;
    }
}
