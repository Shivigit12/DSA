class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        permutations(nums, list, res);
        return res;
    }
    
    public void permutations(int[] nums, List<Integer> list, List<List<Integer>> res) {
        if(list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }else{
            for(int i = 0; i < nums.length; i++) {
                if(list.contains(nums[i]))
                    continue;
                list.add(nums[i]);
                System.out.println(i);
                permutations(nums, list, res);
                list.remove(list.size() - 1);
            }
        }
    }
}