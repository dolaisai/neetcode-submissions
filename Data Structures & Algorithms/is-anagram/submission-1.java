class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character,Integer> sCharFreq = new HashMap();
        HashMap<Character,Integer> tCharFreq = new HashMap();
        if(s.length() != t.length()){
            return false;
        }

        String sUpper = s.toUpperCase();
        String tUpper = t.toUpperCase(); 

        for(int i = 0; i < s.length(); i++){
            sCharFreq.put(sUpper.charAt(i), sCharFreq.getOrDefault(sUpper.charAt(i), 0) + 1);
            tCharFreq.put(tUpper.charAt(i), tCharFreq.getOrDefault(tUpper.charAt(i), 0) + 1);
        } 

        return sCharFreq.equals(tCharFreq); 
    }
}
