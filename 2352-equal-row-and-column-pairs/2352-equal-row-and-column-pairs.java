class Solution {
    public int equalPairs(int[][] grid) {
        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();
        int n = grid.length;
        for(int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < n; j++) {
                sb.append(grid[i][j] + ":");
            }
            String str = sb.toString();
            map1.put(str, map1.getOrDefault(str, 0) + 1);
        }
        for(int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < n; j++) {
                sb.append(grid[j][i] + ":");
            }
            String str = sb.toString();
            map2.put(str, map2.getOrDefault(str, 0) + 1);
        }
        int ans = 0;
        for(String s : map1.keySet()) {
            if(map2.containsKey(s))
                ans = ans + map1.get(s) * map2.get(s);
        }
        return ans;
    }
}