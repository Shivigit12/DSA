class Solution {
     public int findTheCity(int n, int[][] edges, int thresh) {
        int matrix[][] = new int[n][n];
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if(j==i)
                matrix[i][j] = 0;
                else
                matrix[i][j] = (int)(1e9);
            }
        }
        for(int i=0;i<edges.length;i++) {
            matrix[edges[i][0]][edges[i][1]] = edges[i][2];
            matrix[edges[i][1]][edges[i][0]] = edges[i][2];
        }
        for(int k=0;k<n;k++) {
            for(int i=0;i<n;i++) {
                for(int j=0;j<n;j++) {
                    matrix[i][j] = Math.min(matrix[i][j],(matrix[i][k] + matrix[k][j]));
                }
            }
        }
        int minCount = Integer.MAX_VALUE;
        int ans = Integer.MIN_VALUE;
        for(int i=0;i<n;i++) {
            int count = 0;
            for(int j=0;j<n;j++) {
                if(i==j)
                continue;
                if(matrix[i][j] <= thresh)
                count++;
            }
            if(count <= minCount) {
                minCount = count;
                if(i > ans)
                ans = i;
            }
        }
        return ans;
    }
}