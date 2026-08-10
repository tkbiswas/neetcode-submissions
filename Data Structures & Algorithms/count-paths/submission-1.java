class Solution {
    public int uniquePaths(int m, int n) {
        int[][] memo = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                memo[i][j] = -1;
            }
        }
        return path(memo, 0, 0, m , n);
        
    }
    private int path(int[][] memo, int i, int j, int m, int n){
        if(i == m-1 && j == n-1) 
            return 1;
        if(memo[i][j] != -1) 
            return memo[i][j];
        if(i < m-1 && j < n-1) {
            memo[i][j] = path(memo, i+1, j, m, n) + path(memo, i, j+1, m, n);
            return memo[i][j];
        }
        if(i == m-1 && j < n-1){
            memo[i][j] = path(memo, i, j+1, m, n);
            return memo[i][j]; 
        }
        if(i < m-1 && j == n-1){
            memo[i][j] = path(memo, i+1, j, m, n);
            return memo[i][j];
        }
        return 0;
    }
}
