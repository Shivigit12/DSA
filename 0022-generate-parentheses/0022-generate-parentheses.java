class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        String s = "";
        int open = n;
        int close = n;
        solve(open, close, s, list);
        return list;
    }
    
    public void solve(int open, int close, String s, List<String> list) {
        if(open == 0 && close == 0) {
            list.add(s);
            return;
        }
        if(open != 0) {
            String op1 = s;
            op1 = op1 + "(";
            solve(open - 1, close, op1, list);
        }
        if(close > open) {
            String op2 = s;
            op2 = op2 + ")";
            solve(open, close - 1, op2, list);
        }
    }
}