class Solution {
    public int calculate(String s) {
        Stack<Integer> st = new Stack<>();
        int number = 0;
        int result = 0;
        int sign = 1;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                number = number * 10 + (int) (c - '0');
            } else if(c == '+') {
                result = result + sign * number;
                number = 0;
                sign = 1;
            } else if(c == '-') {
                result = result + sign * number;
                number = 0;
                sign = -1;
            } else if (c == '(') {
                st.push(result);
                st.push(sign);
                sign = 1;
                result = 0;
            } else if(c == ')') {
                result = result + sign * number;
                number = 0;
                result = result * st.pop();
                result = result + st.pop();
                
            }
        }
        if(number != 0)
            result = result + sign * number;
        return result;
    }
}