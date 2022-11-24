/*
 * @lc app=leetcode id=42 lang=java
 *
 * [42] Trapping Rain Water
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {
        int iLeft = 0;
        int iRight = height.length - 1;

        int sum = 0;
        int leftMax = height[0];
        int rightMax = height[height.length - 1];
        while (iLeft != iRight) {
            int curLeft = height[iLeft];
            int curRight = height[iRight];
            if (curLeft < curRight) {
                if (leftMax < curLeft) {
                    leftMax = curLeft;
                } else {
                    sum += leftMax - curLeft;
                }
                ++iLeft;
            } else {
                if (rightMax < curRight) {
                    rightMax = curRight;
                } else {
                    sum += rightMax - curRight;
                }
                --iRight;
            }
        }
        return sum;
    }
}
// @lc code=end

