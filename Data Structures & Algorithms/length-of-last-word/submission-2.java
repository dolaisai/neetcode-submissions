class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim(); 
        if(s.length() == 1){
            return 1; 
        }
        int ptr = s.length() - 1; 
        while(s.charAt(ptr) != ' '){
            ptr--;
        }
        String sub = s.substring(ptr+1);
        return sub.length(); 
    }
}