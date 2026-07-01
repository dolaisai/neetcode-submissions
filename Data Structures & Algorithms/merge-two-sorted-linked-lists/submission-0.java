/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //edge cases if one of the lists is empty, return the other. 
        if(list1 == null){
            return list2;
        }
        else if (list2 == null){
            return list1; 
        }
        ListNode dummy = new ListNode(-1);
        ListNode res = dummy; 
        ListNode head = res;
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
        return head.next; 
    }
}