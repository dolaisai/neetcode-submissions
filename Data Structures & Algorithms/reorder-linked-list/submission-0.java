class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null){
            return;
        }
        ListNode slow = head; 
        ListNode fast = head.next; 
        while(fast != null && fast.next != null){
            slow = slow.next; 
            fast = fast.next.next; 
        }
        ListNode prev = null; 
        ListNode curr = slow.next; 
        slow.next = null; 
        while(curr != null){
            ListNode tmp = curr.next; 
            curr.next = prev; 
            prev = curr; 
            curr = tmp; 
        }
        //reassign fast to head;
        //prev is the start of the reversed list. 
        fast = head;
        while(fast != null && prev != null){
            ListNode tmpA = fast.next;
            ListNode tmpB = prev.next; 
            fast.next = prev; 
            prev.next = tmpA; 
            fast = tmpA; 
            prev = tmpB; 
        }
        return; 
    }
}
