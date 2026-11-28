class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int stRow =0, endRow = n-1;
        int stCol =0, endCol =n-1;
        int val=1;
        while(stRow<=endRow && stCol<=endCol){
            //top
            for(int i=stCol; i<=endCol;i++){
                matrix[stRow][i] = val++;
            }
            //right
            for(int i=stRow+1;i<=endRow;i++){
                matrix[i][endCol] = val++;
            }
            //bottom
            for(int i = endCol-1; i>=stCol;i--){
                if(stRow == endRow) break;   
                matrix[endRow][i] = val++;
            }
            //left
            for(int i=endRow-1;i>=stRow+1;i--){
                if(stCol == endCol) break;
                matrix[i][stCol] = val++;
            }
            
            stRow++;
            stCol++;
            endRow--;
            endCol--;
        }

        return matrix;
    }
}