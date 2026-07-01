class Solution {
    public int maxArea(int[] heights) {
       
        int area = 0;
        int left = 0; 
        int right = heights.length - 1;

        while(left < right){
            area = Math.max(area,calcArea(left, right, heights));
            if(heights[left] < heights[right]){
                left++;
            }
            else {
                right--;
            }
        }

        return area;
    }

    public static int calcArea(int left, int right, int[] heights){
        return (right - left) * Math.min(heights[left], heights[right]); 
    } 
}