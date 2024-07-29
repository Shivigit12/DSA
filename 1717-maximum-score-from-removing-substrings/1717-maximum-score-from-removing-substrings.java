class Solution {
    public int maximumGain(String s, int x, int y) {
        int result = 0;
        int topScore, potScore;
        String top, pot;
        if(x > y) {
            top = "ab";
            pot = "ba";
            topScore = x;
            potScore = y;
        } else {
            top = "ba";
            pot = "ab";
            topScore = y;
            potScore = x;
        }
        StringBuilder sb = new StringBuilder();
        for(char ch : s.toCharArray()) {
            if(ch == top.charAt(1) && sb.length() > 0 && sb.charAt(sb.length() - 1) == top.charAt(0)) {
                result = result + topScore;
                sb.setLength(sb.length() - 1);
            } else {
                sb.append(ch);
            }
        }
        StringBuilder newString = new StringBuilder();
        for(char ch : sb.toString().toCharArray()) {
            if(ch == pot.charAt(1) && newString.length() > 0 && newString.charAt(newString.length() - 1) == pot.charAt(0)) {
                result = result + potScore;
                newString.setLength(newString.length() - 1);
            } else {
                newString.append(ch);
            }
        }
        return result;
    }
}