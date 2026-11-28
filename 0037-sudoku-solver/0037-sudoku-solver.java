class Solution {
    private boolean isSafe(char[][] board, int row, int col,char digit){
        //vertical & horizontal
        for(int i=0;i<9;i++){
            if(board[row][i] == digit || board[i][col] == digit) return false;
        }

        //grid
        int sr = (row/3)*3;
        int sc = (col/3)*3;
        for(int i=sr;i<sr+3;i++){
            for(int j=sc;j<sc+3;j++){
                if(board[i][j] == digit) return false;
            }
        }

        return true;
    }
    private boolean solver(char[][] board){
        //base
        for(int row=0;row<9;row++){
            for(int col=0;col<9;col++){
                if(board[row][col]=='.'){
                    for(char digit='1';digit<='9';digit++){
                        if(isSafe(board,row,col,digit)){
                            board[row][col] = digit;
                            if(solver(board)) return true;
                            //backtrack
                            board[row][col] = '.';
                        }
                    }
                    return false;
                }


                
            }
        }
        return true;
    }
    public void solveSudoku(char[][] board) {
        solver(board);
    }
}