class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int i = 0;
        int j = 1;
        int k = 2;
        while(k < arr.length) {
            if(arr[i] % 2 != 0 && arr[j] % 2 != 0 && arr[k] % 2 != 0) {
                return true;
            } else {
                i++;
                j++;
                k++;
            }
            
        }
        return false;
    }
}