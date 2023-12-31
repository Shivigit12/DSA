class Solution {
    public String removeStars(String s) {
        Stack<Character> st = new Stack<>();
        st.push(s.charAt(0));
        for(int i = 1; i < s.length(); i++) {
            if(s.charAt(i) == '*')
                st.pop();
            else
                st.push(s.charAt(i));
        }
        String str = "";
        while(!st.isEmpty()) {
            str = st.pop() + str;
        }
        return str;
    }
}