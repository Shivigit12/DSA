class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        findCombinations(0, candidates, target, list, res);
        return res;
    }
    public void findCombinations(int ind, int[] candidates, int target, List<Integer> list, List<List<Integer>> res) {
        if(ind == candidates.length){
            if(target == 0)
                res.add(new ArrayList<>(list));
            return;
        }else if(candidates[ind] <= target) {
            list.add(candidates[ind]);
            findCombinations(ind, candidates, target - candidates[ind], list, res);
            list.remove(list.size() - 1);
        }
        findCombinations(ind + 1, candidates, target, list, res);
        
    }
}