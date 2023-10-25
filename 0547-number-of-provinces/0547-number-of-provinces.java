class Solution {
    public int findCircleNum(int[][] isConnected) {
        int count = 0;
        boolean[] vis = new boolean[isConnected.length];
        for(int i = 0; i < isConnected.length; i++) {
            if(!vis[i]) {
                bfs(i, isConnected, vis);
                count++;
            }
        }
        return count;
    }
    
    public void bfs(int i, int[][] grid, boolean[] vis) {
        vis[i] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        while(!q.isEmpty()) {
            int j = q.poll();
            for(int k = 0; k < grid.length; k++) {
                if(!vis[k] && grid[j][k] == 1) {
                    vis[k] = true;
                    q.add(k);
                }
            }
        }
    }
}