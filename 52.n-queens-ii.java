/*
 * @lc app=leetcode id=52 lang=java
 *
 * [52] N-Queens II
 */

// @lc code=start
import java.util.*;
class Solution {
    public int totalNQueens(int n) {
        result = 0;
        cols = new int[n];
        colsRecord = 0;
        rightDownRecord = 0;
        leftDownRecord = 0;

        solveNQueensForIndex(0, n);
        return result;
    }

    private void solveNQueensForIndex(int index, int n) {
        if (index == n) {
            // List<String> board = new ArrayList<>(n);
            // char[] line = new char[n];
            // Arrays.fill(line, '.');
            // for (int i = 0; i < n; ++i) {
            //     line[cols[i]] = 'Q';
            //     board.add(new String(line));
            //     line[cols[i]] = '.';
            // }
            ++result;
            return;
        }

        long oldColsRecod = colsRecord;
        long oldRightDownRecord = rightDownRecord;
        long oldLeftDownRecord = leftDownRecord;
        for (int i = 0; i < n; ++i) {
            if ((colsRecord & (1 << i)) != 0) {
                continue;
            }
            int rightDownIndex = i - index + n;
            if ((rightDownRecord & (1 << rightDownIndex)) != 0) {
                continue;
            }
            int leftDownIndex = i + index;
            if ((leftDownRecord & (1 << leftDownIndex)) != 0) {
                continue;
            }
            colsRecord |= (1 << i);
            rightDownRecord |= (1 << rightDownIndex);
            leftDownRecord |= (1 << leftDownIndex);
            cols[index] = i;
            solveNQueensForIndex(index + 1, n);
            colsRecord = oldColsRecod;
            rightDownRecord = oldRightDownRecord;
            leftDownRecord = oldLeftDownRecord;
        }
    }

    private int cols[];
    private int result;
    private long colsRecord;
    private long rightDownRecord;
    private long leftDownRecord;
}
// @lc code=end

