class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length < 1)
        return 0;
        int count = 1;
        int maxCount = 1;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++) {
            if(i > 0 && nums[i] == nums[i - 1])
                continue;
            else if(i > 0 && nums[i] - nums[i - 1] == 1){
                count++;
                maxCount = Math.max(maxCount, count);
            }else
                count = 1;
        }
        return maxCount;
    }
}