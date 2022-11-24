/*
 * @lc app=leetcode id=64 lang=java
 *
 * [64] Minimum Path Sum
 */

// @lc code=start
class Solution {
    public static void main(String[] args) {
        Solution sl = new Solution();
        sl.minPathSum(new int[][]{
            {1,2,3},
            {4,5,6}
        });
    }
    public int minPathSum(int[][] grid) {
        int[] dp = new int[grid[0].length];
        dp[0] = grid[0][0];
        for (int i = 1; i < grid[0].length; ++i) {
            dp[i] = dp[i - 1] + grid[0][i];
        }
        for (int i = 1; i < grid.length; ++i) {
            int[] row = grid[i];
            for (int j = 0; j < row.length; ++j) {
                int prev = j == 0 ? 9999: dp[j - 1];
                int prevMin = prev < dp[j] ? prev : dp[j];
                dp[j] = prevMin + row[j];
            }
        }
        return dp[grid[0].length - 1];
    }
}
// @lc code=end

