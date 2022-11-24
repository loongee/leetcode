/*
 * @lc app=leetcode id=5 lang=java
 *
 * [5] Longest Palindromic Substring
 */

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {
        int maxLen = 1;
        int maxStart = 0;
        for (int i = 0; i < s.length(); ++i) {
            int len = maxPalindromicOdd(s, i);
            if (len > maxLen) {
                maxLen = len;
                maxStart = i - maxLen / 2 + 1;
            }
            
            len = maxPalindromicEven(s, i);
            if (len > maxLen) {
                maxLen = len;
                maxStart = i - maxLen / 2;
            }
        }
        return s.substring(maxStart, maxStart + maxLen);
    }

    public int maxPalindromicOdd(String s, int mid) {
        int maxLen = 0;
        int prev = mid;
        int next = mid + 1;
        while (prev >= 0 && next < s.length() && s.charAt(prev) == s.charAt(next)) {
            prev -= 1;
            next += 1;
            maxLen += 2;
        }
        return maxLen;
    }

    public int maxPalindromicEven(String s, int mid) {
        int maxLen = 1;
        int prev = mid - 1;
        int next = mid + 1;
        while (prev >= 0 && next < s.length() && s.charAt(prev) == s.charAt(next)) {
            prev -= 1;
            next += 1;
            maxLen += 2;
        }
        return maxLen;

    }
}
// @lc code=end

