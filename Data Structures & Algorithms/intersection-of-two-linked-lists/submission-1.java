public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA; 
        ListNode b = headB;
        int aCount = 0;
        int bCount = 0;  

        //get total length of each LL
        while(a != null){
            aCount++;
            a = a.next; 
        }
        while(b != null){
            bCount++; 
            b = b.next; 
        }

        //calc diff in lengths
        int diff = Math.abs(aCount - bCount);

        a = headA; 
        b = headB;
        //offset the larger LL by diff 
        if(aCount > bCount){
            while(diff > 0){
                a = a.next; 
                diff--;
            }
        }
        else{
            while(diff > 0){
                b = b.next; 
                diff--;
            }
        }
        while(a != null && b != null){
            if(a == b){
                return a; 
            }
            a = a.next; 
            b = b.next; 
        }
        return null; 
    }
}