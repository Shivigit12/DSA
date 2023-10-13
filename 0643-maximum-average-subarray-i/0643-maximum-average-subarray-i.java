class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double sum = 0;
        for(int i = 0; i < k; i++) {
            sum = sum + nums[i];
        }
        double avg = sum / (double) k;
        int i = 0;
        int j = k;
        while(j < nums.length) {
            sum = sum + nums[j];
            sum = sum - nums[i];
            avg = Math.max(avg, sum / (double) k);
            i++;
            j++;
        }
        return avg;
    }
}