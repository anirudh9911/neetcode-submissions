class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = board.length;
        boolean[][] rows = new boolean[n][n];
        boolean[][] cols = new boolean[n][n];
        boolean[][] boxes = new boolean[n][n];

        for(int i = 0; i< n; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == '.')continue;
                
                int d = board[i][j] - '1';

                int box = (i/3)*3 + (j/3);

                if(rows[i][d] || cols[j][d] || boxes[box][d]){
                    return false;
                }

                rows[i][d] = true;
                cols[j][d] = true;
                boxes[box][d] = true;
            }
        }
        return true;
    }
}
