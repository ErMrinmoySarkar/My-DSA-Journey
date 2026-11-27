class Solution {
    static int count = 0;
    private void dfs(int[][] grid, int row, int col, int n, int m){
        if(row < 0 || row == n || col < 0 || col == m || grid[row][col] == 0) {
            return;
        }

        grid[row][col] = 0; //visited
        count++;

        dfs(grid, row,col-1,n,m);
        dfs(grid, row,col+1,n,m);
        dfs(grid, row-1,col,n,m);
        dfs(grid, row+1,col,n,m);
    }
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int ans = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1){
                    count = 0;
                    dfs(grid, i, j, n, m);

                    if(count > ans) ans = count;
                }
            }
        }
        return ans;
    }
}