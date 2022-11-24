/*
 * @lc app=leetcode id=50 lang=java
 *
 * [50] Pow(x, n)
 */

// @lc code=start
class Solution {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        if (x == 1.0) {
            return x;
        }
        if (x == -1.0) {
            return n % 2 == 0 ? 1.0 : -1.0;
        }
        if (n == Integer.MIN_VALUE) {
            return 0.0;
        }

        double result = 1.0;
        double curBase = x;
        boolean sign = n < 0;
        if (n < 0) {
            n = -n;
        }

        for (int i = 0; (1 << i) <= n && result != 0.0; ++i) {
            if ((n & (1 << i)) != 0) {
                result *= curBase;
            }
            curBase *= curBase;
        }

        return sign ? 1 / result : result;
    }
}
// @lc code=end

