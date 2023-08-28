class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
      List<List<Integer>> res = new ArrayList<>();
      List<Integer> list = new ArrayList<>();
      subsets(0, nums, list, res);
      List<List<Integer>> newList = new ArrayList<>();
      HashSet<List<Integer>> set = new HashSet<>();
      for(List<Integer> i : res)
        set.add(i);
      for(List<Integer> j : set)
        newList.add(j);
      return newList;
    }
    public void subsets(int ind, int[] nums, List<Integer> list, List<List<Integer>> res) {
      if(ind == nums.length) {
        res.add(new ArrayList<>(list));
        return;
      }
      list.add(nums[ind]);
      subsets(ind + 1, nums, list, res);
      list.remove(list.size() - 1);
      subsets(ind + 1, nums, list, res);
    }
}