class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        Map<Integer,Integer>freq = new HashMap<>();
        for(int i =0; i<n;i++){
            for(int j =0; j<n;j++){
                freq.put(grid[i][j],freq.getOrDefault(grid[i][j],0)+1);
            }
        }

        int repeat = -1, missing = -1;
        for(int digit=1;digit<=n*n;digit++){
            if(!freq.containsKey(digit)) missing = digit; 
            else if(freq.get(digit) == 2) repeat = digit; 
        }

        return new int[]{repeat, missing};

    }
}