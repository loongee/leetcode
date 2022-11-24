/*
 * @lc app=leetcode id=7 lang=java
 *
 * [7] Reverse Integer
 */

// @lc code=start
class Solution {
    public int reverse(int x) {
        int result = 0;

        while (x != 0) {
            int newResult = result << 3;
            if (result != 0 && (newResult ^ result) < 0) {
                return 0;
            }

            int diff = result << 1 + x % 10;
            if (x < 0 && Integer.MIN_VALUE - newResult > diff) {
                return 0;
            }

            if (x > 0 && Integer.MAX_VALUE - newResult < diff) {
                return 0;
            }

            result = newResult + diff;
            x /= 10;
        }

        return result;
    }
}
// @lc code=end

