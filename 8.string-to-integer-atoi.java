/*
 * @lc app=leetcode id=8 lang=java
 *
 * [8] String to Integer (atoi)
 */

// @lc code=start
class Solution {
    public int myAtoi(String s) {
        int index = 0;
        while (index < s.length() && s.charAt(index) == ' ') {
            ++index;
        }

        int sign = 1;
        if (index < s.length() && s.charAt(index) == '+') {
            sign = 1;
            ++index;
        } else if (index < s.length() && s.charAt(index) == '-') {
            sign = -1;
            ++index;
        }

        int result = 0;
        for (; index < s.length(); ++index) {
            char ch = s.charAt(index);
            if (ch < '0' || ch > '9') {
                break;
            }

            int digit = ch - '0';
            if ((Integer.MAX_VALUE - digit) / 10 < result) {
                return sign < 0 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            result = result * 10 + digit;
        }

        return sign * result;
    }
}
// @lc code=end

