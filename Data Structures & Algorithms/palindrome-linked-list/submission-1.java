class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode slow = head; 
        ListNode fast = head; 
        while(fast != null && fast.next != null){
            slow = slow.next; 
            fast = fast.next.next; 
        }
        Stack<Integer> stack = new Stack<>(); 
        if(fast != null){ //list is odd. Skip adding middle node to stack. 
            slow = slow.next;
        }
        
        while(slow != null){
            stack.push(slow.val);
            slow = slow.next;
        }
        ListNode curr = head; 
        while(!stack.isEmpty()){
            int tmp = stack.pop(); 
            if(curr.val != tmp){
                return false; 
            }
            curr = curr.next; 
        }
        return true; 
    }
}