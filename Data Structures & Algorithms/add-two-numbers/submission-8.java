//setup current nodes for both lists
//setup a sum and carry integer var
//iterate through each list as long as one list has a curr != null.
        //sum = 0 (for the start of every iteration)
        //calc sum
        //assign sum remainder to value at current (v1 + v2 + carry)
        //assing sum integer division to carry

        //if left list is null, cont in right list until null
        //if right list is null, cont in left list until null
//check to see if carry is 0
    //if 0 -> return head of list1 (edited list)
    //else -> create new node with val = carry. 
        //assign to end of list. (keep track of prev)
    //return head
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {  
        ListNode dummy = new ListNode(); 
        ListNode curr = dummy;
        int carry = 0;
        int sum = 0; 

        while(l1 != null || l2 != null || carry > 0){
            int val1 = 0; 
            int val2 = 0;
            if(l1 != null){
                val1 = l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                val2 = l2.val;
                l2 = l2.next; 
            }
            sum = val1 + val2 + carry;
            carry = sum / 10; 
            int newVal = sum % 10; 
            ListNode tmp = new ListNode(newVal);
            curr.next = tmp; 
            curr = curr.next; 
        }
       
        return dummy.next;
    }
}
