class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>(); 
        backtrack(candidates, target, 0, result, new ArrayList<Integer>(), 0);
        return result;
    }
    public void backtrack(int[] candidates, int target, int index, List<List<Integer>> result, List<Integer>sublist, int sum){
        //base cases
        if(sum == target){
            result.add(new ArrayList(sublist));
            return;
        }
        if(sum > target || index >= candidates.length){
            return;
        }

        //include candidates[index]
        sublist.add(candidates[index]);
        backtrack(candidates, target, index + 1, result, sublist, sum + candidates[index]);
        sublist.remove(sublist.size() - 1);

        //skip candidates[index]
        while(index + 1 < candidates.length && candidates[index] == candidates[index + 1]){
            index++;
        }
        backtrack(candidates, target, index + 1, result, sublist, sum);
    }
}
