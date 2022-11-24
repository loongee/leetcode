/*
 * @lc app=leetcode id=29 lang=java
 *
 * [29] Divide Two Integers
 */

// @lc code=start
class Solution {
    public static void main(String[] args) {
        Solution sl = new Solution();
        System.out.print(sl.divide(-2147483648, 2));
    }
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        if (divisor == 1) {
            return dividend;
        }

        int sign = ((dividend < 0 ? 1 : 0) ^ (divisor < 0 ? 1 : 0)) == 0 ? 1 : -1;
        dividend = dividend < 0 ? dividend : -dividend;
        divisor = divisor < 0 ? divisor : -divisor;

        int shift = 1;
        int curDelta = divisor << shift;
        while (curDelta < 0 && dividend <= curDelta) {
            ++shift;
            curDelta = divisor << shift;
        }

        --shift;
        int result = 0;
        for (; shift >= 0; --shift) {
            curDelta = divisor << shift;
            while (dividend <= curDelta) {
                dividend -= curDelta;
                result |= 1 << shift;
            }
        }
        return sign * result;
    }
}
// @lc code=end

