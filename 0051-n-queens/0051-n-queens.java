class Solution {
    private boolean isSafe(String[][] board, int row, int col){
        //vertical
        for(int i=row-1;i>=0;i--){
            if(board[i][col] == "Q") return false;
        }
        //left diagonal
        for(int i=row-1,j=col-1; i>=0 && j>=0; i--,j--){
            if(board[i][j] =="Q") return false;
        }
        //right diagonal
        for(int i=row-1,j=col+1;i>=0 && j<board.length;i--,j++){
            if(board[i][j]=="Q") return false;
        }
        return true;
    }
    private void nQueue(String[][] board, int row, List<List<String>> res){
        if(row==board.length){
            res.add(StrtoList(board));
            return;
        }

        for(int col =0;col<board.length;col++){
            if(isSafe(board,row,col)){
                board[row][col] = "Q";
                nQueue(board,row+1,res);

                board[row][col] =".";
            }
        }
    }

    private List<String> StrtoList(String[][] board){
        List<String>posi = new ArrayList<>();
        for(int i=0;i<board.length;i++){
            StringBuilder res = new StringBuilder("");
            for(int j=0;j<board.length;j++){
                res.append(board[i][j]);
            }
            posi.add(res.toString());
        }

        return posi;

    }
    public List<List<String>> solveNQueens(int n) {
        String[][] board = new String[n][n];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                board[i][j] = ".";
            }
        }
        List<List<String>> res = new ArrayList<>();
        nQueue(board,0,res);
        return res;
        
    }
}