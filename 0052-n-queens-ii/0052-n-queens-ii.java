class Solution {
    private boolean isSafe(char board[][],int row,int col){
        //vertical
        for(int i=row-1;i>=0;i--){
            if(board[i][col] =='Q') return false;
        }

        //left Diagonal
        for(int i=row-1, j=col-1; i>=0 && j>=0;i--,j--){
            if(board[i][j] == 'Q') return false;
        }

        //right Diagonal
        for(int i=row-1,j=col+1;i>=0 && j<board.length;i--,j++){
            if(board[i][j] == 'Q') return false;
        }

        return true;
    }
    private int solve(char board[][], int row){
        //base case
        if(row == board.length){
            return 1;
        }
        //recusion
        int count =0;
        for(int col=0;col<board.length;col++){
            if(isSafe(board,row,col)){
                board[row][col] = 'Q';
                count+=solve(board, row+1);

                //backtracking
                board[row][col] ='x';
            }
        }
        return count;
    }
    public int totalNQueens(int n) {
        char[][] board = new char[n][n];
        int placeQueensCount = solve(board,0);
        return placeQueensCount;
    }
}