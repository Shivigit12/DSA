class Solution {
    public int findCircleNum(int[][] isConnected) {
        boolean vis[] = new boolean[isConnected.length];
        int c = 0;
        for(int i = 0; i < isConnected.length; i++) {
            if(!vis[i]) {
                bfs(i, isConnected, vis);
                c++;
            }
        }
        return c;
    }
    
    public void bfs(int s, int[][] grid, boolean[] vis) {
        vis[s] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        while(!q.isEmpty()) {
            int j = q.poll();
            for(int i = 0; i < grid[j].length; i++) {
                if(!vis[i] && grid[j][i] == 1) {
                    vis[i] = true;
                    q.add(i);
                }
            }
        }
    }
}