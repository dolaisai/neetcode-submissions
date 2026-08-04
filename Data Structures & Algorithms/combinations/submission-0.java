class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>(); 
        backtrack(n, k, new ArrayList<Integer>(), 1, res);
        return res; 
    }

    public void backtrack(int n, int k, List<Integer> sublist, int start,  List<List<Integer>> res){
        if(sublist.size() == k){
            res.add(new ArrayList(sublist));
            return;
        }
        for(int i = start; i <= n; i++){
            sublist.add(i);
            backtrack(n, k, sublist, i + 1, res);
            sublist.remove(sublist.size() - 1);
        }
        return; 
    }
}