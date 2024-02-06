class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int total = 0;
        for(int i : nums) {
            total += i;
        }
        int max = nums[0], maxSum = nums[0], min = nums[0], minSum = nums[0];
        
        for(int i = 1; i < nums.length; i++) {
            max = Math.max(max + nums[i], nums[i]);
            maxSum = Math.max(max, maxSum);
            
            min = Math.min(min + nums[i], nums[i]);
            minSum = Math.min(min, minSum);
        }
       
        return maxSum > 0 ? Math.max((total - minSum), maxSum) : maxSum;
    }
}