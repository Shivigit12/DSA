class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int temp[] = new int[2 * n];
        int totalOnes = 0;
        int minSwap = Integer.MAX_VALUE;
       
        for(int i = 0; i < 2 * n; i++) {
            if(nums[i % n] == 1)
                totalOnes++;
            temp[i] = nums[i % n];
        }
        if(totalOnes == 0)
            return 0;
        int tempOnes = 0;
        totalOnes /= 2;
        for(int i = 0; i < 2 * n; i++) {
            if(temp[i] == 1)
                tempOnes++;
            if(i >= totalOnes - 1) {
                minSwap = Math.min(minSwap, totalOnes - tempOnes);
                tempOnes -= temp[i - totalOnes + 1];
            }
        }
        return minSwap;
    }
}