class Solution {
    public int characterReplacement(String s, int k) {
        //hashmap (character, charFreq)
        //left pointer at start
        //for(right = 0 -> s.length())
            //update freq of character at index right in map
                //if no charfreq exists, default to 0 and add 1. 
            //while(windowSize - max(charfreq in map) > k)
                //decrement charAt(left)'s charFreq
                //left++
            //update max(max, windowsize) outside of while
        //return max. 

        HashMap<Character, Integer> freq = new HashMap(); 
        int left = 0; 
        int max = 0; 
        for(int right = 0; right < s.length(); right++){
            freq.put(s.charAt(right), freq.getOrDefault(s.charAt(right), 0) + 1);
            while((right - left + 1) - maxFreq(freq) > k){
                freq.put(s.charAt(left), freq.get(s.charAt(left)) - 1);
                left++;
            }
            max = Math.max(max, (right - left + 1));
        }
        return max; 
    }

    public int maxFreq(HashMap<Character, Integer> freq){
        int max = 0; 
        for(Integer i : freq.values()){
            max = Math.max(max, i);
        }
        return max; 
    }
}
