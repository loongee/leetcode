import java.security.InvalidParameterException;

/*
 * @lc app=leetcode id=37 lang=java
 *
 * [37] Sudoku Solver
 */

// @lc code=start
class Solution {
    public void solveSudoku(char[][] board) {
        int startPos = -1;
        for (int i = 0; i < board.length; ++i) {
            char[] data = board[i];
            for (int j = 0; j < data.length; ++j) {
                if (data[j] == '.') {
                    data[j] = '0';
                    if (startPos == -1) {
                        startPos = i * 9 + j;
                    }
                }
            }
        }

        if (startPos >= 0) {
            if (!solveSudokuRecursive(board, startPos)) {
                throw new ArithmeticException();
            }
        }
    }

    private boolean solveSudokuRecursive(char[][] board, int pos) {
        int row = pos / 9;
        int col = pos % 9;
        int occupied = 0;

        for (int i = 0; i < 9; ++i) {
            occupied |= (1 << (board[row][i] - '0'));
            occupied |= (1 << (board[i][col] - '0'));
        }

        int startRow = row / 3 * 3;
        int startCol = col / 3 * 3;
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                occupied |= (1 << (board[startRow + j][startCol + i] - '0'));
            }
        }

        int nextPos = pos + 1;
        while (nextPos < 81 && board[nextPos / 9][nextPos % 9] != '0') {
            ++nextPos;
        }

        for (int i = 1; i < 10; ++i) {
            if ((occupied & (1 << i)) == 0) {
                board[row][col] = (char)(i + '0');

                if (nextPos == 81) {
                    return true;
                }

                if (solveSudokuRecursive(board, nextPos)) {
                    return true;
                }
            }
        }
        board[row][col] = '0';
        return false;
    }
}
// @lc code=end

