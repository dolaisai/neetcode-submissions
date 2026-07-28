class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head; 
        ListNode fast = head; 
        while(fast != null && fast.next != null){
            slow = slow.next; 
            fast = fast.next.next; 
        }
        Stack<Integer> stack = new Stack<>(); 
        if(fast == null){
            stack.push(slow.val);
        }
        slow = slow.next;
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