class MyHashMap {

    private Node[] hashMap; 

    private int numberOfNodes = 0; 
    private static final double LOAD_FACTOR = 0.75;         

    public MyHashMap() {
        hashMap = new Node[1009];
        for(int i = 0; i < hashMap.length; i++){
            hashMap[i] = new Node(-1, -1, null);
        }
    }
    
    public void put(int key, int value) {

        //check to see if load exceeds 75% 
        int threshold = (int) (hashMap.length * LOAD_FACTOR);
        if(numberOfNodes > threshold ){
            rehash();
        }

        int idx = key % hashMap.length;
        Node prev = hashMap[idx];
        Node curr = prev.next;
        while(curr != null){
            if(curr.key == key){
                curr.value = value;
                return;
            }
            curr = curr.next; 
            prev = prev.next;
        }
        curr = new Node(key, value, null);
        prev.next = curr; 
        numberOfNodes++;
    }
    
    public int get(int key) {
        int idx = key % hashMap.length;
        Node curr = hashMap[idx];
        while(curr != null){
            if(curr.key == key){
                return curr.value;
            } 
            curr = curr.next;
        }
        return -1;
    }
    
    public void remove(int key) {
        int idx = key % hashMap.length;
        Node prev = hashMap[idx];
        Node curr = prev.next;
        while(curr != null){
            if(curr.key == key){
                prev.next = curr.next; 
                curr.next = null;
                numberOfNodes--;
                return; 
            }
            curr = curr.next; 
            prev = prev.next; 
        }
    }

    public void rehash(){
        //declare new hashmap of double size
        Node[] newHashMap = new Node[hashMap.length * 2];
        //fill with dummy starter nodes. 
        for(int i = 0; i < newHashMap.length; i++){
            newHashMap[i] = new Node(-1,-1,null);
        }
        //for all Node chains in old map, compute new hash value and add to newHashMap. 
        for(Node node : hashMap){
            //offset off of dummy
            node = node.next; 
            //iterate through legit nodes if they exist and move them over to newHashMap
            while(node != null){
                int idx = node.key % newHashMap.length;
                Node prev = newHashMap[idx];
                Node curr = prev.next;
                while(curr != null){
                    if(curr.key == node.key){
                        curr.value = node.value;
                        return;
                    }
                    curr = curr.next; 
                    prev = prev.next;
                }
                curr = new Node(node.key, node.value, null);
                prev.next = curr;  
            }
            
        }
        //finally assign newHashMap to old one. 
        hashMap = newHashMap; 
    }
}

public class Node {
    private int key;
    private int value;
    private Node next; 

    public Node(int key, int value, Node node){
        this.key = key; 
        this.value = value; 
        this.next = node; 
    }
}

