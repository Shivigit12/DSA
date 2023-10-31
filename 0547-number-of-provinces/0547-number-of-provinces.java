class Solution {
    public int findCircleNum(int[][] isConnected) {
        int count = 0;
        boolean[] vis = new boolean[isConnected.length];
        for(int i = 0; i < isConnected.length; i++) {
            if(!vis[i]) {
                dfs(i, isConnected, vis);
                count++;
            }
        }
        return count;
    }
    
    public void dfs(int i, int[][] grid, boolean[] vis) {
        vis[i] = true;
        for(int j = 0; j < grid.length; j++) {
            if(grid[i][j] == 1 && !vis[j]) {
                dfs(j, grid, vis);
            }
        }
    }
}