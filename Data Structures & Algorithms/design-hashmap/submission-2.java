class MyHashMap {
    private int[] hashMap;
    private int MAX = 1000001;
    public MyHashMap() {
        hashMap = new int[MAX];
        Arrays.fill(hashMap, -1);
    }
    
    public void put(int key, int value) {
        int idx = key % MAX; 
        hashMap[idx] = value;   
    }
    
    public int get(int key) {
        int idx = key % MAX; 
        return hashMap[idx];
    }
    
    public void remove(int key) {
        int idx = key % MAX; 
        hashMap[idx] = -1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */