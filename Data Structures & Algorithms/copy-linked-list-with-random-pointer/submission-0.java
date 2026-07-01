/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
        
class Solution {
    public Node copyRandomList(Node head) {
        //create a hashmap to hold node value (key) and random index (value)
        //iterate through head
            //create a new listnode
            //assign prev.next to new list node
            //save list node.random to hash table. 
        //iterate through newly created list
            //assign random pointer of each node based on the random value saved in hashmap. 

        HashMap<Node, Node> map = new HashMap(); 
          
        Node curr = head; 
        while(curr != null){
            Node tmp = new Node(curr.val);
            map.put(curr, tmp);
            curr = curr.next; 
        }
        
        curr = head;
        Node res = map.get(head); 
         
        while(curr != null){
            Node copy = map.get(curr);
            copy.next = map.get(curr.next);
            copy.random = map.get(curr.random);
            curr = curr.next;

        }
        
        return res;
    }
}
