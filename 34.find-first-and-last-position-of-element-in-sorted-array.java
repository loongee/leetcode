/*
 * @lc app=leetcode id=34 lang=java
 *
 * [34] Find First and Last Position of Element in Sorted Array
 */

// @lc code=start
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }

        int leftBound = findBound(nums, target, true);
        int rightBound = findBound(nums, target, false) - 1;

        if (leftBound > rightBound || nums[leftBound] != target) {
            return new int[]{-1, -1};
        }
        return new int[]{leftBound, rightBound};
    }

    public int findBound(int[] nums, int target, boolean lower) {
        int left = 0;
        int right = nums.length - 1;

        while(left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target || (!lower && nums[mid] <= target)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
// @lc code=end

