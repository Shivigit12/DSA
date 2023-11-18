class Solution {
    public String decodeString(String s) {
        Stack<Integer> counts = new Stack();
        Stack<String> string = new Stack();
        String str = "";
        int index = 0;
        while(index < s.length()) {
            if(Character.isDigit(s.charAt(index))) {
                int count = 0;
                while(Character.isDigit(s.charAt(index))) {
                    count = 10 * count +  (s.charAt(index) - '0');
                    index++;
                }
                counts.push(count);
                
            } else if(s.charAt(index) == '[') {
                string.push(str);
                str = "";
                index++;
                
                
            } else if(s.charAt(index) == ']') {
                StringBuilder sb = new StringBuilder(string.pop());
                int counter = counts.pop();
                for(int i = 0; i < counter; i++) {
                    sb.append(str);
                }
                str = sb.toString();
                index++;
            } else {
                str = str + s.charAt(index);
                index++;
            }
        }
        return str;
    }
}