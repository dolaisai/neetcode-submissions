class Solution {
    public int arrangeCoins(int n) {
        //Gauss' Formula: n/2(n + 1)
        int left = 0; 
        int right = n; 
        int max = 0; 

        while(left <= right){
            int mid = left + (right - left) / 2;
            long gauss = (long) mid * (mid + 1) / 2;
            if(gauss == n){
                return mid; 
            }
            else if(gauss > n){
                right = mid - 1; 
            }
            else{
                left = mid + 1; 
                max = Math.max(max, mid); 
            }
        }
        return max; 
    }
}