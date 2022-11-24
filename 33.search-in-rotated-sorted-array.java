/*
 * @lc app=leetcode id=33 lang=java
 *
 * [33] Search in Rotated Sorted Array
 */

// @lc code=start
class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        if (nums[left] == target) {
            return left;
        }
        if (nums[right] == target) {
            return right;
        }

        while(left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[0] <= nums[mid]) {
                if (nums[mid] > target && nums[0] < target) {
                    right = mid - 1;
                } else {
                    left = left + 1;
                }
            } else {
                if (nums[mid] < target && target < nums[0]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
}
// @lc code=end

