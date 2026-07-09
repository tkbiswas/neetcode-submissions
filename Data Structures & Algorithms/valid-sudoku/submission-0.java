class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (char[] chars : board) {
            var rowSet = new HashSet<Character>();
            for (int q = 0; q < board[0].length; q++) {
                if (chars[q] != '.') {
                    boolean added = rowSet.add(chars[q]);
                    if (!added)
                        return false;
                }
            }
        }
        for (int i = 0; i < board[0].length; i++) {
            var colSet = new HashSet<Character>();
            for (int q = 0; q < board[0].length; q++) {
                if (board[q][i] != '.') {
                    boolean added = colSet.add(board[q][i]);
                    if (!added)
                        return false;
                }
            }
        }

        for (int square = 0; square < 9; square++) {
            var unique = new HashSet<Character>();
            for (int i = 0; i < 3; i++) {
                for (int q = 0; q < 3; q++) {
                    int row = (square / 3) * 3 + i;
                    int col = (square % 3) * 3 + q;
                    if (board[row][col] != '.') {
                        boolean added = unique.add(board[row][col]);
                        if (!added)
                            return false;
                    }
                }
            }
        }


        return true;
    }
}
