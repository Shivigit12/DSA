class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1)
            return s;
        StringBuilder sb = new StringBuilder();
        int diff = 2 * (numRows - 1);
        int index;
        int n = s.length();
        int secondDiff = diff;
        int secondIndex;
        for(int i = 0; i < numRows; i++) {
            index = i;
            while(index < n) {
                sb.append(s.charAt(index));
                if(i != 0 && i != numRows - 1) {
                    secondDiff = diff - 2 * i;
                    secondIndex = index + secondDiff;
                    if(secondIndex < n) {
                        sb.append(s.charAt(secondIndex));
                    }
                }
                index = index + diff;
            }
        }
        return sb.toString();
    }
}