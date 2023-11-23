class Solution {
    int ans = -1;
    public int findTheWinner(int n, int k) {
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
            list.add(i);
        }
        k = k - 1;
        int index = 0;
        solve(list, k, index);
        return ans;
    }
    public void solve(List<Integer> list, int k, int index) {
        if(list.size() == 1) {
            ans = list.get(0);
            return;
        }
        
        index = (index + k) % list.size();
        list.remove(index);
        solve(list, k, index);
    }
}