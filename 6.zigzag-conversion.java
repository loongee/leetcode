/*
 * @lc app=leetcode id=6 lang=java
 *
 * [6] Zigzag Conversion
 */

// @lc code=start
class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        
        StringBuilder result = new StringBuilder(s.length());
        for (int i = 0; i < numRows; ++i) {
            for (int j = 0; true; ++j) {
                int index = j * (2 * numRows - 2) + i;
                if (index >= s.length()) {
                    break;
                }
                result.append(s.charAt(index));

                if (i != 0 && i != numRows - 1) {
                    index = (j + 1) * (2 * numRows - 2) - i;
                    if (index >= s.length()) {
                        break;
                    }
                    result.append(s.charAt(index));
                }
            }
        }
        return result.toString();
    }
}
// @lc code=end

