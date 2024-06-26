class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int i = nums.length - 3;
        int j = nums.length - 2;
        int k = nums.length - 1;
        if(nums.length < 3)
            return 0;
        while(i >= 0) {
            if(nums[i] + nums[j] > nums[k])
                return nums[i] + nums[j] + nums[k];
            else {
                i--;
                j--;
                k--;
            }
        }
        return 0;
    }
}