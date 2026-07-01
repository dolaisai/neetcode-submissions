class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String s : strs){
            String key = charFreq(s);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(s);
        }

        return new ArrayList(map.values());
    }

    public static String charFreq(String indexStr){
        int[] freq = new int[26];
        for(char c : indexStr.toCharArray()){
            freq[c - 'a']++;
        }

        return Arrays.toString(freq);
    } 
}
