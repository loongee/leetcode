/*
 * @lc app=leetcode id=36 lang=java
 *
 * [36] Valid Sudoku
 */

// @lc code=start
class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; ++i) {
            char[] data = board[i];
            for (int j = 0; j < data.length; ++j) {
                if (data[j] != '.') {
                    if (!isCellValid(board, i * 9 + j)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean isCellValid(char[][] board, int pos) {
        int row = pos / 9;
        int col = pos % 9;

        char curCh = board[row][col];
        for (int i = 0; i < 9; ++i) {
            if ((i != col && board[row][i] == curCh) || (i != row && board[i][col] == curCh)) {
                return false;
            }
        }

        int startRow = row / 3 * 3;
        int startCol = col / 3 * 3;
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                if (startRow + j != row && startCol + i != col 
                && board[startRow + j][startCol + i] == curCh) {
                    return false;
                }
            }
        }
        return true;
    }
}
// @lc code=end

