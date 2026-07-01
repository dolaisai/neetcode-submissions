class Solution {
    public int evalRPN(String[] tokens) {
        //use a stack
            //while not operator push onto stack
            //once operator is found, pop numbers off of stack and do calc
            //save answer in local var
            //cont. w/while
            //once encounter 

        Stack<Integer> nums = new Stack();

        int i = 0;
        while(i < tokens.length){
            int acc = 0;
            if( !tokens[i].equals("+") && 
                !tokens[i].equals("-") && 
                !tokens[i].equals("*") && 
                !tokens[i].equals("/")){

                    nums.push(Integer.parseInt(tokens[i]));
            }
            else{
                if(nums.empty()){
                    return -1;
                }
                else{
                    int num1 = nums.pop();
                    int num2 = nums.pop();
                    switch (tokens[i]){
                        case "+":
                            acc = num2 + num1;
                            break; 
                        case "-":
                            acc = num2 - num1;
                            break; 
                        case "*":
                            acc = num2 * num1;
                            break;
                        case "/":
                            acc = num2 / num1;
                            break;
                    }
                    nums.push(acc);
                }
            }
            i++;
        }
        return nums.peek(); 
    }
}
