class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head);
        ListNode previousGroup = dummy; 

        while(true){
            ListNode kthNode = getKthNode(previousGroup, k); 
            if(kthNode == null){
                break; 
            }
            
            ListNode nextGroup = kthNode.next; 

            //reverse group
            ListNode prev = kthNode.next; 
            ListNode curr = previousGroup.next; 
            while(curr != nextGroup){
                ListNode tmp = curr.next; 
                curr.next = prev; 
                prev = curr; 
                curr = tmp; 
            }
            ListNode tmp = previousGroup.next; 
            previousGroup.next = kthNode; 
            previousGroup = tmp; 
        }

        return dummy.next; 
    }

    public ListNode getKthNode(ListNode curr,int k){
        while(curr != null && k > 0){
            curr = curr.next; 
            k--;
        }
        return curr; 
    }
}
