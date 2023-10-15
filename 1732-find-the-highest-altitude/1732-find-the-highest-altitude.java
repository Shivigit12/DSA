class Solution {
    public int largestAltitude(int[] gain) {
        int maxHeight = Integer.MIN_VALUE;
        int g = 0;
        for(int i = 0; i < gain.length; i++) {
            g = g + gain[i];
            maxHeight = Math.max(g, maxHeight);
        }
        return Math.max(maxHeight, 0);
    }
}