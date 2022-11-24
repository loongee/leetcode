/*
 * @lc app=leetcode id=41 lang=java
 *
 * [41] First Missing Positive
 */

// @lc code=start
class Solution {
    public static void main(String[] args) {
        Solution sl = new Solution();
        sl.firstMissingPositive(new int[]{1, 1});
    }
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        boolean lastN = false;
        for (int i = 0; i < n; ++i) {
            for (int j = i; j != nums[j] && nums[j] != 0;) {
                if (nums[j] <= 0 || nums[j] > n) {
                    nums[j] = 0;
                    break;
                } else if (nums[j] == n) {
                    lastN = true;
                    nums[j] = 0;
                } else if (nums[j] == j) {
                    break;
                } else {
                    int tmp = nums[j];
                    if (tmp == nums[tmp]) {
                        nums[j] = 0;
                        break;
                    }
                    nums[j] = nums[tmp];
                    nums[tmp] = tmp;
                }
            }
        }

        for (int i = 1; i < n; ++i) {
            if (nums[i] == 0) {
                return i;
            }
        }
        return lastN ? n + 1 : n;
    }
}
// @lc code=end

