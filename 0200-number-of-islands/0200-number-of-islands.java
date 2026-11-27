class Solution {
    private void dfs(int row, int col, char grid[][], int n, int m){
        //base case
        if(row<0 || col<0 || row==n || col==m ||grid[row][col]=='0') return;

        grid[row][col] = '0'; //like visited

        dfs(row-1,col,grid,n,m); // row-up
        dfs(row+1,col,grid,n,m); //row-down
        dfs(row,col-1,grid,n,m); //col-left
        dfs(row,col+1,grid,n,m); //col-right
    }

    public int numIslands(char[][] grid) {
        int count =0;
        int n = grid.length;
        int m = grid[0].length;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(i,j,grid,n,m);
                }
            }
        }

        return count;
    }
}