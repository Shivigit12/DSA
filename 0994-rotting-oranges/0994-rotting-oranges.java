class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int minutes = -1;
        int freshCount = 0;
        int m = grid.length;
        int n = grid[0].length;

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 2) q.offer(new int[]{i, j}); //gathering rotten oranges to queue
                else if(grid[i][j] == 1) freshCount++;
            }
        }

        if(freshCount == 0) return 0; //there is no fresh orange.
        if(q.size() == 0) return -1; //there is noting to rotten.
        while(!q.isEmpty()) {
            minutes++;
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int[] node = q.poll();
                for(int j = 0; j < dirs.length; j++) {
                    int x = node[0] + dirs[j][0];
                    int y = node[1] + dirs[j][1];
                    if(x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1) {
                        grid[x][y] = 2;
                        freshCount--;
                        q.offer(new int[]{x, y});
                    }
                }
            }
            
        }
        return freshCount != 0 ? -1 : minutes;
    }
}