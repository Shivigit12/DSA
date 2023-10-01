class Solution {
    public void sortColors(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        int ptr = 0;
        while(i < j && ptr <= j) {
            if(nums[ptr] == 0) {
                nums[ptr] = nums[i];
                nums[i] = 0;
                i++;
                ptr++;
            }else if(nums[ptr] == 2) {
                nums[ptr] = nums[j];
                nums[j] = 2;
                j--;
               
            }else
                ptr++;
           
        }
    }
}