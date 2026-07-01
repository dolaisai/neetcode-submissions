class Solution {
    public int minimumRecolors(String blocks, int k) {
        //global var for keeping track of min seen so far. 
        //setup sliding window of size k where all elements within window size are a valid answer
            //keep track of a count of white blocks
            //after window is full size, check to see if right element (new element) makes window invalid (white block)
            //+ 1 to count. 
            //check to see if left pointer (block being removed from window) is white or black
            //if white, count --

        int minOps = 0;
        int whiteCount = 0; 
        
        //build window phase. up to k size  
        for(int i = 0; i < k; i++){
            if(blocks.charAt(i) == 'W'){
                whiteCount++;
            }
        }
        //assign initial min to white blocks found in window build up phase. 
        minOps = whiteCount;

        //slide window, checking ends to update whiteCount
        int left = 0; 
        for(int right = k; right < blocks.length(); right++){
            if(blocks.charAt(right) == 'W'){
                whiteCount++;
            }
            if(blocks.charAt(left) == 'W'){
                whiteCount--;
                if(whiteCount < 0){
                    whiteCount = 0;
                }
            }
            minOps = Math.min(minOps, whiteCount);
            left++;
        }

        return minOps; 
    }
}