class Node{
    private int key; 
    private int val; 
    private Node prev = null; 
    private Node next = null; 

    public Node(int key, int val){
        this.key = key;
        this.val = val; 
    }
}
class LRUCache {
    HashMap<Integer, Node> map;
    Node left = new Node(0,0);
    Node right = new Node(0,0);
    private int capacity; 

    public LRUCache(int capacity) {
        map = new HashMap<>();
        //left is the least recently used.
        //right is the most recently used. 
        left.next = right; 
        right.prev = left; 
        this.capacity = capacity; 
    }
    public int get(int key) {
        if(map.containsKey(key)){
            Node tmp = map.get(key);
            remove(tmp);
            insertRight(tmp);
            return tmp.val;
        }
        return -1; 
    }
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            remove(node);
        }
        Node node = new Node(key, value);
        map.put(key, node);
        insertRight(node);
        if(map.size() > capacity){
            //remove and delete the LRU
            Node lru = left.next; 
            remove(lru);
            map.remove(lru.key);
        }
    }
    public void remove(Node node){
        Node prev = node.prev; 
        Node next = node.next; 
        prev.next = next; 
        next.prev = prev;
    }
    public void insertRight(Node node){
        Node prev = right.prev;
        Node next = right; 
        prev.next = node; 
        next.prev = node;
        node.next = next;
        node.prev = prev; 
    }
}
