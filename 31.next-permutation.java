/*
 * @lc app=leetcode id=31 lang=java
 *
 * [31] Next Permutation
 */

// @lc code=start
class Solution {
    public static void main(String[] args) {
        Solution sl = new Solution();
        sl.nextPermutation(new int[]{1,5,1});
    }
    public void nextPermutation(int[] nums) {
        int end = nums.length - 1;
        while (end > 0 && nums[end - 1] >= nums[end]) --end;
        if (end == 0) {
            reverse(nums, 0, nums.length - 1);
        } else {
            int largetIndex = findIndexOfLarger(nums, end, nums[end - 1]);
            int tmp = nums[largetIndex];
            nums[largetIndex] = nums[end - 1];
            nums[end - 1] = tmp;
            reverse(nums, end, nums.length - 1);
        }
    }

    private int findIndexOfLarger(int[] nums, int start, int target) {
        int left = start;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] <= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left - 1;
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int tmp = nums[end];
            nums[end] = nums[start];
            nums[start] = tmp;
            ++start;
            --end;
        }
    }
}
// @lc code=end

