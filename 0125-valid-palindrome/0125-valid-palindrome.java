class Solution {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        if(Palindrome(s, 0))
            return true;
        return false;
        
        
    }
    public boolean Palindrome(String s, int i){
    
    if(i>=s.length()/2) return true;
            
            // If start is not equal to end, not palindrome.
            if(s.charAt(i)!=s.charAt(s.length()-i-1)) return false;
            
            // If both characters are same, increment i and check start+1 and end-1.
            return Palindrome(s, i+1);
    }
}