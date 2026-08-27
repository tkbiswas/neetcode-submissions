class Solution {
    public void islandsAndTreasure(int[][] grid) {
       Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0)
                    q.add(new int[]{i, j});
            }
        }

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int row = poll[0];
            int col = poll[1];
            addToQ(grid, q, row + 1, col, grid[row][col]);
            addToQ(grid, q, row - 1, col, grid[row][col]);
            addToQ(grid, q, row, col + 1, grid[row][col]);
            addToQ(grid, q, row, col - 1, grid[row][col]);
        }


    }

    private void addToQ(int[][] grid, Queue<int[]> q, int r, int c, int curDist) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] != Integer.MAX_VALUE)
            return;
        q.add(new int[]{r, c});
        grid[r][c] = curDist + 1;

    }
}
