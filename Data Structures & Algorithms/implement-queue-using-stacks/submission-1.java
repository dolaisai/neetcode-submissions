class MyQueue { 
        Stack<Integer> s1; 
        Stack<Integer> s2; 
        public MyQueue() { 
                s1 = new Stack<>(); 
                s2 = new Stack<>(); 
        } 
        public void push(int x) { 
                s1.push(x); 
        } 
        public int pop() { 
                while(s1.size() > 1){ 
                        s2.push(s1.pop()); 
                } 
                int res = s1.pop(); 
                while(!s2.isEmpty()){ 
                        s1.push(s2.pop()); 
                } 
                return res; 
        } 
        public int peek() { 
                while(s1.size() > 1){ 
                        s2.push(s1.pop()); 
                } 
                int res = s1.peek(); 
                while(!s2.isEmpty()){ 
                        s1.push(s2.pop()); 
                } 
                return res; 
        } 
        public boolean empty() {
                return s1.isEmpty(); 
        } 
}