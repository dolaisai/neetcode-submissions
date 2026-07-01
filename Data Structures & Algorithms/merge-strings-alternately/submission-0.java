class Solution {
    public String mergeAlternately(String word1, String word2) {
        String smaller = word1;
        String larger = word2; 
        if(smaller.length() >= larger.length()){
            String tmp = "";
            tmp = smaller; 
            smaller = larger; 
            larger = tmp; 
        }

        int p1 = 0; 
        int p2 = 0; 
        StringBuilder res = new StringBuilder(""); 

        while(p1 < smaller.length()){
            res.append(word1.charAt(p1));
            res.append(word2.charAt(p2)); 
            p1++; 
            p2++;
        }
        while(p2 < larger.length()){
            res.append(larger.charAt(p2));
            p2++;
        }
        return res.toString(); 
    }
}