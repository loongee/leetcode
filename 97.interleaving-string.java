/*
 * @lc app=leetcode id=97 lang=java
 *
 * [97] Interleaving String
 */

// @lc code=start
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        char[] c1 = s1.toCharArray(), c2 = s2.toCharArray(), c3 = s3.toCharArray();
        if (s3.length() != s1.length() + s2.length()) {
            return false;
        }
        
        boolean[] valid = new boolean[s2.length() + 1];
        valid[0] = true;
        for (int i = 0; i < s1.length() + 1; ++i) {
            int j = i == 0 ? 1 : 0;
            for (; j < s2.length() + 1; ++j) {
                valid[j] = (i > 0 && valid[j] && c1[i - 1] == c3[i + j - 1])
                    || (j > 0 && valid[j - 1] && c2[j - 1] == c3[i + j - 1]);
            }
        }
        return valid[s2.length()];
    }
}
// @lc code=end

