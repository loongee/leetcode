/*
 * @lc app=leetcode id=27 lang=java
 *
 * [27] Remove Element
 */

// @lc code=start
class Solution {
    public int removeElement(int[] nums, int val) {
        int curIndex = 0;
        int nextIndex = 0;
        while (true) {
            while (nextIndex < nums.length && nums[nextIndex] == val) {
                ++nextIndex;
            }

            if (nextIndex == nums.length) {
                break;
            }

            nums[curIndex] = nums[nextIndex];
            ++curIndex;
            ++nextIndex;
        }
        return curIndex;
    }
}
// @lc code=end

