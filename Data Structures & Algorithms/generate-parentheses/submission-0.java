class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>(); 
        backtrack(n, new StringBuilder("("), res, n - 1, n);
        return res; 
    }
    public void backtrack(int n, StringBuilder sub, List<String> res, int open, int close){
        if(sub.length() == (n * 2)){
            res.add(sub.toString());
            return; 
        }
        //options checks
        if (open > 0) {
            sub.append('(');
            backtrack(n, sub, res, open - 1, close);
            sub.deleteCharAt(sub.length() - 1);
        }

        if (close > open) {
            sub.append(')');
            backtrack(n, sub, res, open, close - 1);
            sub.deleteCharAt(sub.length() - 1);
        }
        return; 
    }
}
