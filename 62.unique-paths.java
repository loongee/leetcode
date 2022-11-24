/*
 * @lc app=leetcode id=62 lang=java
 *
 * [62] Unique Paths
 */

// @lc code=start
class Solution {
    public int uniquePaths(int m, int n) {
        // 解题最终结果： (m - 1 + n - 1)! / (m - 1)! / (n - 1)!    -----!号表示阶乘
        if (m == 1 || n == 1) {
            return 1;
        }

        // 预处理，把m和n先行减1，变为 (m + n)! / m! / n!
        m -= 1;
        n -= 1;

        // 保证m比较大，后续减少计算量
        if (m < n) {
            int tmp = m;
            m = n;
            n = tmp;
        }

        // (m + n)! / (m! * n!)，上下同时约去 m!，得 (m + 1) * (m + 2) * …… * (m + n) / n!
        // 此时需证明m, n取任意值时，此等式仍为整数
        // 由于(m + n)! / m! / n!意为从m个白球，n个红球的全排列数，根据概率相关知识，结果必然为整数，可得: 取任意的m,x
        // 设P(m,x) = (m + x)! / m! / x!，则P(m, x) = P(m, x - 1) * (m + x) / x
        // (m + 1) * (m + 2) * …… (m + x) / x! 仍然为整数
        // 而根据题目要求，最终结果不会超过2 * 10e9，m和n均<=100，因此中间步骤用long即可存下中间结果
        long result = 1;
        for (int i = 1; i <= n; ++i) {
            result *= (m + i);  // 如果result用int, 则此步骤可能会溢出，所以必须用long
            result /= i;  // 上述证明主要证明此步骤不会产生非整除而导致精度丢失
        }
        return (int) result;
    }
}
// @lc code=end

