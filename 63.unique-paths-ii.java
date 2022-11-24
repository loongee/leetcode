/*
 * @lc app=leetcode id=63 lang=java
 *
 * [63] Unique Paths II
 */

// @lc code=start
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[] dp = new int[obstacleGrid[0].length];
        dp[0] = 1;
        for (int i = 0; i < obstacleGrid.length; ++i) {
            int[] row = obstacleGrid[i];
            for (int j = 0; j < row.length; ++j) {
                if (row[j] == 1) {
                    dp[j] = 0;
                } else {
                    dp[j] += (j == 0 ? 0 : dp[j - 1]);
                }
            }
        }
        return dp[obstacleGrid[0].length - 1];
    }
}
// @lc code=end

