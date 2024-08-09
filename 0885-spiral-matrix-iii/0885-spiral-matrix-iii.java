class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
        int[][] ans = new int[rows * cols][2];
        ans[0] = new int[]{rStart, cStart};
        int dir = 0;
        int steps = 0;
        int count = 1;
        while(count < rows * cols)
        {
          if(dir == 0 || dir == 2)
          {
            steps++;
          }

          for(int i = 0; i < steps; i++)
          {
            rStart += directions[dir][0];
            cStart += directions[dir][1];

            if(rStart >= 0 && cStart >= 0 && rStart < rows && cStart < cols)
            {
              ans[count++] = new int[]{rStart,cStart};
            }
          }

          dir = (dir + 1) % 4;
        }

        return ans;
    }
}