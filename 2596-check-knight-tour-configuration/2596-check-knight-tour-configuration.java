class Solution {
    private boolean isSafe(int grid[][], int row, int col, int n, int expVal){
        //is safe part
        if(row<0 ||col<0 || row>=n || col>=n || grid[row][col] != expVal){
            return false;
        }

        //base case
        if(expVal==n*n-1){
            return true;
        }

        boolean ans1 = isSafe(grid, row-2, col+1, n, expVal+1);
        boolean ans2 = isSafe(grid, row-1, col+2, n, expVal+1);
        boolean ans3 = isSafe(grid, row+1, col+2, n, expVal+1);
        boolean ans4 = isSafe(grid, row+2, col+1, n, expVal+1);
        boolean ans5 = isSafe(grid, row+2, col-1, n, expVal+1);
        boolean ans6 = isSafe(grid, row+1, col-2, n, expVal+1);
        boolean ans7 = isSafe(grid, row-1, col-2, n, expVal+1);
        boolean ans8 = isSafe(grid, row-2, col-1, n, expVal+1);

        return ans1||ans2||ans3||ans4||ans5||ans6||ans7||ans8;
    }
    public boolean checkValidGrid(int[][] grid) {
        return isSafe(grid,0,0,grid.length,0);
    }
}