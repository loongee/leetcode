/*
 * @lc app=leetcode id=125 lang=java
 *
 * [125] Valid Palindrome
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            char leftCh = s.charAt(left);
            if (!((leftCh >= 'a' && leftCh <= 'z') || (leftCh >= '0' && leftCh <= '9'))) {
                ++left;
                continue;
            }

            char rightCh = s.charAt(right);
            if (!((rightCh >= 'a' && rightCh <= 'z') || (rightCh >= '0' && rightCh <= '9'))) {
                --right;
                continue;
            }

            if (leftCh != rightCh) {
                return false;
            }
            ++left;
            --right;
        }
        return true;
    }
}
// @lc code=end

