class MinStack {

    Stack<Integer> stack; 
    Stack<Integer> minStack; 

    public MinStack() {
        this.stack = new Stack(); 
        this.minStack = new Stack(); 
    }
    
    public void push(int val) {
        if(minStack.empty()){
            stack.push(val);
            minStack.push(val); 
        }
        else{
            stack.push(val);
            minStack.push(Math.min(minStack.peek(), val));
        }
    }
    
    public void pop() {
        stack.pop();
        minStack.pop(); 
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
