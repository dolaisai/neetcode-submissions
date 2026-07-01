class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        //find max value in array. This will be the upper bound of our k threshold. 1 is the lower. 
        //build k array from 1 - max in increasing order. 
        //perform binary search
        //while left <= right
            //calculate mid. 
            //calculate total hours to eat all bananas. ( sum of ceil(piles / mid) for piles.length) 
            //if sum is < h, 
                //set current min eat rate, 
                //move into left half of binary search arr. 
            //else 
                //eating rate was too small. move into the right half of the array. 
            
            //return 

        int max = findMax(piles);  

        int left = 0; 
        int right = max;
        int minEatRate = 0;

        while(left <= right){
            int mid = left + (right - left) / 2; 
            int hours = 0; 
            for(int i = 0; i < piles.length; i++){
                hours += Math.ceil((double)piles[i] / mid);
            }
            if(hours <= h){
                minEatRate = mid;
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        return minEatRate; 
    }
    public int findMax(int[] arr){
        int globalMax = arr[0];
        for(int i = 0; i < arr.length; i++){
            globalMax = Math.max(globalMax, arr[i]);
        }
        return globalMax;
    }
}
