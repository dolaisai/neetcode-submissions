class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //edge case: if one of the lists is empty, return the other. 
        if(list1 == null){
            return list2;
        }
        else if (list2 == null){
            return list1; 
        }
        ListNode dummy = new ListNode(-1);
        ListNode res = dummy; 
        ListNode curr1 = list1; 
        ListNode curr2 = list2; 
        //merge
        while(curr1 != null && curr2 != null){
            if(curr1.val <= curr2.val){
                res.next = curr1; 
                res = res.next; 
                curr1 = curr1.next; 
            }
            else{
                res.next = curr2; 
                res = res.next; 
                 curr2 = curr2.next;
            }
        }
        if(curr1 == null && curr2 != null){
            res.next = curr2; 
        }
        if(curr2 == null && curr1 != null){
            res.next = curr1; 
        }
        return dummy.next; 
    }
}