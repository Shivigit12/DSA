class Solution {
    public int dfs(int[][] grid, int i, int j) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length)
            return 0;
        if(grid[i][j] == 1)
            return 0;
        grid[i][j] = 1;
        return 1 + dfs(grid, i, j + 1) + dfs(grid, i, j - 1) + dfs(grid, i + 1, j) + dfs(grid, i - 1, j);
    }
    public int regionsBySlashes(String[] grid) {
        int ans = 0;
        int mat[][] = new int[grid.length * 3][grid.length * 3];
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid.length; j++) {
                if(grid[i].charAt(j) == '/')
                    mat[i * 3 + 2][j * 3] = mat[i * 3 + 1][j * 3 + 1] = mat[i * 3][j * 3 + 2] = 1;
                if(grid[i].charAt(j) == '\\')
                    mat[i * 3][j * 3] = mat[i * 3 + 1][j * 3 + 1] = mat[i * 3 + 2][j * 3 + 2] = 1;
            }
        }
        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat[0].length; j++) {
                ans += dfs(mat, i, j) >= 1 ? 1 : 0;
            }
        }
        return ans;
    }
}