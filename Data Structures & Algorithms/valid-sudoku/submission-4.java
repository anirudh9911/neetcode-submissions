class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = board.length;
        for(int i = 0; i< n; i++){
            for(int j =0; j< n; j++){
                if(board[i][j] == '.')continue;

                if(!checkRules(board, i, j)){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkRules(char[][] board, int row, int col){
        int n = board.length;
        char val = board[row][col];
        for(int i = 0; i< n; i++){
            if((i != col && board[row][i] == val) || (i != row && board[i][col] == val)){
                return false;
            }
        }

        int subRow = (row/3)*3;
        int subCol = (col/3)*3;

        for(int i = subRow; i < subRow+3; i++){
            for(int j = subCol; j < subCol+3; j++){
                if(i!= row && j!= col && board[i][j] == val){
                    return false;
                }
            }
        }
        return true;
    }
}
