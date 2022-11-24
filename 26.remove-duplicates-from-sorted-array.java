/*
 * @lc app=leetcode id=26 lang=java
 *
 * [26] Remove Duplicates from Sorted Array
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        int curIndex = 0;
        int nextIndex = 1;
        while (true) {
            while(nextIndex < nums.length && nums[nextIndex] == nums[nextIndex - 1]) {
                ++nextIndex;
            }
            if (nextIndex >= nums.length) {
                break;
            }

            ++curIndex;
            nums[curIndex] = nums[nextIndex];
            ++nextIndex;
        }
        return curIndex + 1;
    }
}
// @lc code=end

