class Solution {
    public String removeDuplicates(String s, int k) {
        StringBuilder sb = new StringBuilder();
        Stack<Pair> st = new Stack<>();
        for(char c : s.toCharArray()) {
            if(!st.isEmpty() && st.peek().ch == c) {
                if(++st.peek().a == k)
                    st.pop();
            } else {
                st.push(new Pair(1, c));
            }
        }
        while(!st.isEmpty()) {
            Pair p = st.pop();
            char ch = p.ch;
            int n = p.a;
            for(int i = 1; i <= n; i++) {
                sb.append(ch);
            }
        }
        return sb.reverse().toString();
    }
    
}
 class Pair {
     int a;
     char ch;
     public Pair(int a, char ch) {
        this.a = a;
        this.ch = ch;
     }
 }