class StockSpanner {
    Stack<Integer> stack; 
    public StockSpanner() {
        stack = new Stack<Integer>(); 
    }
    
    public int next(int price) {
        Stack<Integer> hold = new Stack<>(); 
        int count = 1; 
        while(!stack.isEmpty() && stack.peek() <= price){
            count++;
            hold.push(stack.pop());
        }
        while(!hold.isEmpty()){
            stack.push(hold.pop());
        }
        stack.push(price); 
        return count;   
    }
}