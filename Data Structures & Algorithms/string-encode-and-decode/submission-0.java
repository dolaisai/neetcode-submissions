class Solution {

    public String encode(List<String> strs) {
        List<Integer> sizes = new ArrayList<>();
        StringBuilder encString = new StringBuilder();

        if(strs.size() == 0){
            return encString.toString();
        }


        //iterate through all strings and add their sizes to sizes array
        for(int i = 0; i < strs.size(); i++){
            int len = strs.get(i).length(); 
            encString.append(len);
            encString.append(",");   
        }

        //append separation character 
        encString.append("&");

        //append all strings from strs to encString
        for(String s : strs){
            encString.append(s);
        }
        
        return encString.toString(); 

    }

    public List<String> decode(String str) {
        System.out.println(str);
        
        //check to see if string is empty. If so, return empty list
        if(str.equals("")){
            return new ArrayList<String>();
        }

        //initialize a list to hold String sizes and a start and end index
        List<Integer> sizes = new ArrayList<Integer>();
        int start = 0; 
        int end = 0;
        int symbolPos = 0;

        //run until end index becomes greater than length of string 
        //or until the '&' is found. 
        while(end < str.length()){
            if(str.charAt(end) == '&'){
                symbolPos = end;
                break;
            }
            //update end index if ',' is not found
            while(str.charAt(end) != ','){
                end++;
                
            }
            //get substring of str with start/end index and convert to int
            int len = Integer.parseInt(str.substring(start, end));
            
            sizes.add(len);
            //update start and end index and increment past ','
            start = end + 1;
            end++;
        }
        List<String> res = new ArrayList<String>();
        //assign index to where symbol was found above and increment by 1
        int index = symbolPos + 1;
        for(Integer i : sizes){
            res.add(str.substring(index, index + i));
            index += i;
        }

        return res; 
    }
}
