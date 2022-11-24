/*
 * @lc app=leetcode id=540 lang=java
 *
 * [540] Single Element in a Sorted Array
 */

// @lc code=start
class Solution {
    public int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) >> 1;
            int midOdd = mid & ~1;
            int midEven = midOdd + 1;

            if (nums[midEven] == nums[midOdd]) {
                left = midEven + 1;
            } else {
                right = midOdd - 1;
            }
        }
        return nums[left];
    }
}
// @lc code=end

