class Solution {
    public int longestSubarray(int[] nums) {
        int ans = 0;
        int countzero = 0;
        int left = 0;
        for(int right = 0; right < nums.length; right++) {
            if(nums[right] == 0)
                countzero++;
            while(countzero > 1) {
                if(nums[left] == 0)
                    countzero--;
                left++;
            }
            
            ans = Math.max(ans, right - left + 1 - countzero);    
        }
        return ans == nums.length ? ans - 1: ans;
        
    }
}