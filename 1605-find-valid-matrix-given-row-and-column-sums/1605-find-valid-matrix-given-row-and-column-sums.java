class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int m = rowSum.length;
        int n = colSum.length;
        int ans[][] = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(rowSum[i] < colSum[j]) {
                    ans[i][j] = rowSum[i];
                } else if(rowSum[i] > colSum[j]) {
                    ans[i][j] = colSum[j];
                } else {
                    ans[i][j] = colSum[j];
                }
                rowSum[i] = rowSum[i] - ans[i][j];
                colSum[j] = colSum[j] - ans[i][j];
            }
        }
        return ans;
    }
}