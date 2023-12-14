class Solution {
    public void gameOfLife(int[][] board) {
        int row = board.length;
        int col = board[0].length;
        int arr[][] = new int[row][col];
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                int lives = neighbour(board, i - 1, j - 1) + neighbour(board, i, j - 1) +neighbour(board, i + 1, j - 1) +
                    neighbour(board, i - 1, j) +neighbour(board, i - 1, j + 1) +neighbour(board, i + 1, j + 1) +
                    neighbour(board, i + 1, j) +neighbour(board, i, j + 1);
                
                if(board[i][j] == 1) {
                    arr[i][j] = (lives < 2 || lives > 3) ? 0 : 1;
                }else{
                    arr[i][j] = (lives == 3) ? 1 : 0;
                }
            }
        }
        for(int r = 0; r < row; r++){
            board[r] = arr[r].clone();                                                
        }
        
            
    }
    int neighbour(int[][] board, int i, int j) {
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == 0)
            return 0;
        return 1;
    }
        
}