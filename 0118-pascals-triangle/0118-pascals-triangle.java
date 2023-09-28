class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> prev = new ArrayList<>();
        List<Integer> list;
        for(int i = 0; i < numRows; i++) {
            list = new ArrayList<>();
            for(int j = 0; j <= i; j++) {
                if(j == 0 || j == i)
                    list.add(1);
                else
                    list.add(prev.get(j - 1) + prev.get(j));
                
            }
            prev = list;
            res.add(list);
        }
        return res;
    }
}