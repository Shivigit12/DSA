class Solution {
    public int strStr(String haystack, String needle) {
        if(needle != null)
            return haystack.indexOf(needle);
        return 0;
    }
}