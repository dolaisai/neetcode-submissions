class Solution {
    public String minWindow(String s, String t) {
        String res = "";
        //declare hashmaps for tFreq and window. 
        HashMap<Character, Integer> tFreq = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();

        //initialize tFreq map with chars and their freq in t
        for(int i = 0; i < t.length(); i++){
            char c = t.charAt(i);
            tFreq.put(c, tFreq.getOrDefault(c, 0) + 1);
        }

        //initialize int vars for have and need
        int have = 0; 
        int need = tFreq.size(); 

        //initialize int var for min length so far and indices
        int[] resIndices = new int[2];
        int minLenSoFar = Integer.MAX_VALUE;

        int left = 0; 
        for(int right = 0; right < s.length(); right++){
            char rChar = s.charAt(right);
            window.put(rChar, window.getOrDefault(rChar, 0) + 1);

            if(tFreq.containsKey(rChar) && window.get(rChar) == tFreq.get(rChar)){
                have++;
            }
            while(have == need){
                if(right - left + 1 < minLenSoFar){
                    resIndices[0] = left; 
                    resIndices[1] = right; 
                    minLenSoFar = right - left + 1;
                }
                char lChar = s.charAt(left);
                window.put(lChar, window.get(lChar) - 1);
                if(tFreq.containsKey(lChar) && 
                        window.get(lChar) < tFreq.get(lChar)){
                        have--;
                }
                left++;
            }
        }
        if(minLenSoFar != Integer.MAX_VALUE){
            res = s.substring(resIndices[0], resIndices[1] + 1);
        }
        return res;
    }
}
