class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        findCombinations(list, res, n, k, 1);
        return res;
    }
    
    public void findCombinations(List<Integer> list, List<List<Integer>> res, int n, int k, int start) {
        if(list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = start; i <= n; i++) {
            list.add(i);
            findCombinations(list, res, n, k, i + 1);
            list.remove(list.size() - 1);
        }
    }
}