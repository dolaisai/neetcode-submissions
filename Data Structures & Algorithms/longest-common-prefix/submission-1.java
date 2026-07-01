class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder res = new StringBuilder("");
        if(strs.length == 0){
            return res.toString(); 
        }
        if(strs.length == 1){
            return strs[0];
        }
        String smallest = strs[0];
        for(String s : strs){
            if(s.length() < smallest.length()){
                smallest = s; 
            }
        } 

        for(int i = 0; i < smallest.length(); i++){
           for(String s : strs){
                if(s.charAt(i) != smallest.charAt(i)){
                    return res.toString(); 
                }
            }
            res.append(smallest.charAt(i)); 

        }
        return res.toString(); 
    }
}