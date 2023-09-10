class Solution {
    int maxLen = 0;
    int start = 0;
    public String longestPalindrome(String s) {
        if(s.length() <= 1)
            return s;
        for(int i = 0; i < s.length(); i++) {
            expandFromCenter(i, i, s);
            expandFromCenter(i, i + 1, s);
            
        }
        return s.substring(start, start + maxLen + 1);
    }
    
    public void expandFromCenter(int i, int j, String s) {
        if(i < 0 && j >= s.length())
            return;
        while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        i++;
        j--;
        if(maxLen < j - i) {
            maxLen = j - i;
            start = i;
        }
            
    }
}