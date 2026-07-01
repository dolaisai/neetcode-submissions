class Solution {
    public int[] topKFrequent(int[] nums, int k) {
         
        HashMap<Integer, Integer> numFreqMap = new HashMap<Integer, Integer>();
        List<Integer>[] freq = new List[nums.length + 1];

        //populate freq array with Empty ArrayLists
        for(int i = 0; i < freq.length; i++){
            freq[i] = new ArrayList<>();
        }

        //hashmap key = value of nums[i], 
        //hashmap value = incremented frequency of the occurance of nums[i]
        for(int number : nums){
            numFreqMap.put(number, numFreqMap.getOrDefault(number, 0) + 1);
        }

        //for each entry set(key,value) in hashmap, place key into the list at index[value of entry];
        for(Map.Entry<Integer,Integer> entry : numFreqMap.entrySet()){
            freq[entry.getValue()].add(entry.getKey());
        }

        //iterate through freq list from greatest index to smallest and return k int values from the lists of ints
        int[] res = new int[k];
        int index = 0;
        
        for (int i = freq.length - 1; (i > 0) && (index < k); i--) {
            for (int n : freq[i]) {
                res[index++] = n;
                if (index == k) {
                    return res;
                }
            }
        }
        return res;
            
    } 
}
