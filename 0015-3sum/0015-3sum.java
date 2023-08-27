class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> res = new HashSet<>();
        List<List<Integer>> ans = new ArrayList<>();
        int sum = 0;
        for(int i = 0; i < nums.length - 2; i++) {
            if(i > 0 && nums[i - 1] == nums[i])
                continue;
            int j = i + 1;
            int k = nums.length - 1;
            while(j < k) {
                sum = nums[i] + nums[j] + nums[k];
                if(sum == 0){
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                }else if(sum < 0)
                    j++;
                else
                    k--;
                
                
            }
        }
        for(List<Integer> i : res)
            ans.add(i);
        return ans;
    }
}