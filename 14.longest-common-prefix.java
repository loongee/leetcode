/*
 * @lc app=leetcode id=14 lang=java
 *
 * [14] Longest Common Prefix
 */

// @lc code=start
class Solution {
    public String longestCommonPrefix(String[] strs) {
        int index = 0;
        while (true) {
            if (index >= strs[0].length()) {
                break;
            }
            char ch = strs[0].charAt(index);
            for (int i = 1; i < strs.length; ++i) {
                if (index >= strs[i].length() || strs[i].charAt(index) != ch) {
                    return strs[i].substring(0, index);
                }
            }
            ++index;
        }
        return strs[0].substring(0, index);
    }
}
// @lc code=end

