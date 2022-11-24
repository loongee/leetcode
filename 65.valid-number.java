/*
 * @lc app=leetcode id=65 lang=java
 *
 * [65] Valid Number
 */

// @lc code=start
class Solution {
    public static void main(String[] args) {
        Solution sl = new Solution();
        sl.isNumber("2e0");
    }
    public boolean isNumber(String s) {
        int nextStart = skipDecimal(s, 0);
        if (nextStart <= 0) {
            return false;
        }
        if (nextStart == s.length()) {
            return true;
        }

        if (s.charAt(nextStart) == 'e' || s.charAt(nextStart) == 'E') {
            ++nextStart;
            if (nextStart == s.length()) {
                return false;
            }
            nextStart = skipInteger(s, nextStart);
        }
        return nextStart == s.length();
    }

    public int skipDecimal(String s, int start) {
        boolean dotFound = false;
        boolean numberFound = false;
        int cur = start;

        if (s.charAt(cur) == '+' || s.charAt(cur) == '-') {
            ++cur;
        }
        for (; cur < s.length(); ++cur) {
            char ch = s.charAt(cur);
            if (ch == '.') {
                if (dotFound) {
                    return cur;
                } else {
                    dotFound = true;
                    continue;
                }
            }
            if (ch >= '0' && ch <= '9') {
                numberFound = true;
                continue;
            } else {
                break;
            }
        }
        return numberFound ? cur : -1;
    }

    public int skipInteger(String s, int start) {
        int cur = start;
        boolean numberFound = false;
        if (s.charAt(cur) == '+' || s.charAt(cur) == '-') {
            ++cur;
        }
        while (cur < s.length() && s.charAt(cur) >= '0' && s.charAt(cur) <= '9') {
            numberFound = true;
            ++cur;
        }
        return numberFound ? cur : -1;
    }
}
// @lc code=end

