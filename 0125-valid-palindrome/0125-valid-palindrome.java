class Solution {
    public boolean isPalindrome(String s) {
        String str = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        return isValid(str, 0);
    }
    
    public boolean isValid(String str, int i) {
        if(i >= str.length() / 2)
            return true;
        if(str.charAt(i) != str.charAt(str.length() - 1 - i))
            return false;
        return isValid(str, i + 1);
    }
}