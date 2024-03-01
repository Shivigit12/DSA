class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1)
            return s;
        StringBuilder sb = new StringBuilder();
        int diff = 2 * (numRows - 1);
        int n = s.length();
        int diagonalDiff = diff;
        int secondIndex;
        int index;
        for(int i = 0; i < numRows; i++) {
            index = i;
            while(index < n) {
                sb.append(s.charAt(index));
                if(i != 0 && i != numRows - 1) {
                    diagonalDiff = diff - 2 * i;
                    secondIndex = index + diagonalDiff;
                    
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