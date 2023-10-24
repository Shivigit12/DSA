class Solution {
    public boolean increasingTriplet(int[] nums) {
        int num1 = Integer.MAX_VALUE;
        int num2 = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] < num1 && nums[i] < num2)
                num1 = nums[i];
            if(nums[i] > num1 && nums[i] < num2)
                num2 = nums[i];
            if(nums[i] > num1 && nums[i] > num2)
                return true;
        }
        return false;
    }
}