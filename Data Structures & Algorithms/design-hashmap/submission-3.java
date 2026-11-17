class MyHashMap {

    private Node[] hashMap; 

    public MyHashMap() {
        hashMap = new Node[1009];
        for(int i = 0; i < hashMap.length; i++){
            hashMap[i] = new Node(-1, -1, null);
        }
    }
    
    public void put(int key, int value) {
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
    }
    
    public int get(int key) {
        int idx = key % hashMap.length;
        Node prev = hashMap[idx];
        Node curr = prev.next;
        while(curr != null){
            if(curr.key == key){
                return curr.value;
            }
            prev = prev.next; 
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
                return; 
            }
            curr = curr.next; 
            prev = prev.next; 
        }
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

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */