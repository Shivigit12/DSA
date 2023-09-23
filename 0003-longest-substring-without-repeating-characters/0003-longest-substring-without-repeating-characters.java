class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int i = 0;
        int j = 0;
        int count = 0;
        while(i < s.length()) {
            if(!set.contains(s.charAt(i))){
                set.add(s.charAt(i));
                i++;
                count = Math.max(count, set.size());
            }
            else{
                set.remove(s.charAt(j));
                j++;
                
            }
        }
        return count;
    }
}