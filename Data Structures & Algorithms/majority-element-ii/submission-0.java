class Solution {
    public List<Integer> majorityElement(int[] nums) {
         HashMap<Integer, Integer> map = new HashMap<>(); 

         for(int i : nums){
            map.put(i, map.getOrDefault(i, 0) + 1);
            if(map.size() <= 2){
                continue; 
            }
            HashMap<Integer, Integer> tmp = new HashMap<>();
            for(Integer key : map.keySet()){
                if(map.get(key) > 1){
                    tmp.put(key, map.get(key) - 1);
                }
            }
            map = tmp; 
         }

        List<Integer> res = new ArrayList<>();
        for (int key : map.keySet()) {
            int count = 0;
            for (int num : nums) {
                if (num == key) count++;
            }
            if (count > nums.length / 3) {
                res.add(key);
            }
        }

        return res;
    }
}