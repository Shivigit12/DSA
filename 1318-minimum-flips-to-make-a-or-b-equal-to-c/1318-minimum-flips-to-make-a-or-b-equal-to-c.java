class Solution {
    public int minFlips(int a, int b, int c) {
        int result = 0;
        for(int i = 0; i < 32; i++) {
            int aBit = a & 1;
            int bBit = b & 1;
            int cBit = c & 1;
            if((aBit | bBit) != cBit) {
                result = result + (aBit + bBit + cBit);
            }
            a = a >> 1;
            b = b >> 1;
            c = c >> 1;
        }
        return result;
    }
}