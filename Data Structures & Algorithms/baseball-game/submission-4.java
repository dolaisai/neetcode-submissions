class Solution {
    public int calPoints(String[] operations) {
        Stack<String> stack = new Stack<>(); 

        for(String s : operations){
            switch(s){
                case "+":{
                    int a = Integer.parseInt(stack.pop());
                    int b = Integer.parseInt(stack.pop());
                    stack.push(String.valueOf(b)); 
                    stack.push(String.valueOf(a));
                    stack.push(String.valueOf(a + b));
                    break; 
                }
                case "D":{
                    int a = Integer.parseInt(stack.peek());
                    stack.push(String.valueOf(a * 2));
                    break; 
                }
                case "C":{
                    stack.pop();
                    break; 
                }
                default: {
                    stack.push(s);
                    break; 
                }
            }
        }
        int res = 0; 
        while(!stack.isEmpty()){
            res += Integer.parseInt(stack.pop());
        }
        return res; 
    }
}