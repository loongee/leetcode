/*
 * @lc app=leetcode id=945 lang=java
 *
 * [945] Minimum Increment to Make Array Unique
 */

// @lc code=start

import java.util.*;
class Solution {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] <= nums[i - 1]) {
                result += (nums[i - 1] - nums[i] + 1);
                nums[i] = nums[i - 1] + 1;
            }
        }
        return result;
    }
}
// @lc code=end

