class TimeMap {

    private Map<String, List<Pair>> map;

    public TimeMap() {
        map = new HashMap<>(); 
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)){
            Pair pair = new Pair(timestamp, value);
            List<Pair> entry = new ArrayList<>(); 
            entry.add(pair); 
            map.put(key, entry);
        }
        else{
            List<Pair> entry = map.get(key);
            Pair pair = new Pair(timestamp, value);
            entry.add(pair); 
            map.put(key, entry);
        }
    }
    
    public String get(String key, int timestamp) {
        List<Pair> valuesAtKey = map.getOrDefault(key, new ArrayList<>());

        String res = ""; 
        int left = 0; 
        int right = valuesAtKey.size() - 1; 
        while(left <= right){ 
            int mid = left + (right - left) / 2; 
            if(valuesAtKey.get(mid).timestamp <= timestamp){
                res = valuesAtKey.get(mid).value; 
                left = mid + 1; 
            }
            else{
                right = mid - 1; 
            }
        }
        return res; 
    }

    public record Pair(Integer timestamp, String value) {}
}
