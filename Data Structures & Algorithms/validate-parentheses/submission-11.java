class Solution {
    public boolean isValid(String s) {
        //edge cases
        if(s.equals("")){
            return false; 
        }
        if(s.length() % 2 == 1){
            return false; 
        }
        if(     s.charAt(0) == ')' ||
                s.charAt(0) == ']' ||
                s.charAt(0) == '}'){
                    return false; 
                }

        Stack<Character> charStack = new Stack();
        
        int index = 0; 
        while(index < s.length()){
            while(  s.charAt(index) != ')' &&
                    s.charAt(index) != ']' &&
                    s.charAt(index) != '}' && 
                    index != s.length() - 1){
                        
                        charStack.push(s.charAt(index));
                        index++;
            }
            if(index == s.length()){
                return false;
            }
            if(charStack.empty()){
                return false; 
            }

            if( s.charAt(index) == ']' && 
            charStack.peek() == '['){
            charStack.pop();
            }
            else if( s.charAt(index) == ')' && 
                charStack.peek() == '('){
                charStack.pop();
            }
            else if( s.charAt(index) == '}' && 
                charStack.peek() == '{'){
                charStack.pop();
            }
            else{
                return false;
            }
            index++;
        }
        if(!charStack.empty()){
                return false; 
            }
        return true; 
    }
}
