class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode dummy = new ListNode(); 
        dummy.next = head;
        ListNode slow = dummy; 
        ListNode fast = dummy; 
        while(fast != null && fast.next != null){
            slow = slow.next; 
            fast = fast.next.next; 
        }

        slow = reverseList(slow);
        ListNode curr = head; 
        while(slow != null){
            if(slow.val != curr.val){
                return false; 
            }
            slow = slow.next; 
            curr = curr.next; 
        }
        return true; 
    }
    public ListNode reverseList(ListNode start){
        ListNode curr = start.next; 
        ListNode prev = null;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev; 
    }
}