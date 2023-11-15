class Solution {
    public int largestAltitude(int[] gain) {
        int maxAltitude = Integer.MIN_VALUE;
        int gSum = 0;
        for(int i = 0; i < gain.length; i++) {
            gSum = gSum + gain[i];
            maxAltitude = Math.max(gSum, maxAltitude);
        }
        return Math.max(maxAltitude, 0);
    }
}