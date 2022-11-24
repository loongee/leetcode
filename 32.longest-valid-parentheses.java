/*
 * @lc app=leetcode id=32 lang=java
 *
 * [32] Longest Valid Parentheses
 */

// @lc code=start
class Solution {
    public int longestValidParentheses(String s) {
        int[] bestMatchLen = new int[s.length()];
        int maxLen = 0;

        for (int i = 0; i < s.length(); ++i) {
            char chr = s.charAt(i);
            if (i == 0 || chr == '(') continue;
            if (s.charAt(i - 1) == '(') {
                bestMatchLen[i] = 2;
                if (i > 1) {
                    bestMatchLen[i] += bestMatchLen[i - 2];
                }
            } else if (s.charAt(i - 1) == ')') {
                int prevIndex = i - 1 - bestMatchLen[i - 1];
                if (prevIndex >= 0 && s.charAt(prevIndex) == '(') {
                    bestMatchLen[i] = bestMatchLen[i - 1] + 2;
                    if (prevIndex > 1) {
                        bestMatchLen[i] += bestMatchLen[prevIndex - 1];
                    }
                }
            }

            if (bestMatchLen[i] > maxLen) {
                maxLen = bestMatchLen[i];
            }
        }

        return maxLen;
    }
}
// @lc code=end

