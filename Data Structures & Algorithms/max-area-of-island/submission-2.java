class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int area =0;
        for(int row =0; row < grid.length; row++){
            for(int col =0; col < grid[0].length; col++){
                if(grid[row][col] == 1){
                    int curArea = dfs(grid, row, col, 0);
                    area = Math.max(area, curArea);
                }   
            }
        }
        return area;
    }

    private int dfs(int[][] grid, int r, int c, int curArea){
            if(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] ==0)
                return curArea;
            curArea += 1;
            grid[r][c] =0;
            return curArea + dfs(grid, r+1, c, 0)+dfs(grid, r-1, c,0)+ dfs(grid, r, c+1,0)+dfs(grid, r, c-1,0);
            
    }
}
