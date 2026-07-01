class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] s1Freq = new int[26];
        int[] s2Freq = new int[26];
        //setup freq array for s1
        for(int i = 0; i < s1.length(); i++){
            s1Freq[s1.charAt(i) - 'a']++;
        }
        //build window for freq in s2
        for(int i = 0; i < s1.length(); i++){
            s2Freq[s2.charAt(i) - 'a']++;
        }
        //check if initial window build is a permutation
        if(Arrays.compare(s1Freq,s2Freq) == 0){
            return true; 
        }
        int left = 0; 
        for(int right = s1.length(); right < s2.length(); right++){
            s2Freq[s2.charAt(right) - 'a']++;
            s2Freq[s2.charAt(left) - 'a']--;

            if(Arrays.compare(s1Freq,s2Freq) == 0){
                return true; 
            }
            left++;
        }
        return false;
    }
}
