class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode curr = head;
        int index = 0;
        while(curr != null){
            curr = curr.next;
            index++; 
        }
        
        if(index < n){
            return head; 
        }

        //stop at the node before the one we want to remove.
        int stop = index - n; 
        index = 0;
        curr = head;
        ListNode prev = null;
         if (stop == 0) {
            return head.next;
        }

        while(index < stop){
            prev = curr; 
            curr = curr.next;
            index++; 
        }
         
        if(curr == null){
            prev.next = null; 
        }
        else{
            prev.next = curr.next;
            curr.next = null; 
        }

        return head;
    }
}
