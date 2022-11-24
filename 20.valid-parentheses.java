/*
 * @lc app=leetcode id=20 lang=java
 *
 * [20] Valid Parentheses
 */

// @lc code=start
import java.util.*;
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
                continue;
            }
            if (stack.empty()) {
                return false;
            }
            char lastCh = stack.pop();
            if ((lastCh == '(' && ch == ')')
            || (lastCh == '[' && ch == ']')
            || (lastCh == '{' && ch == '}')) {
                continue;
            }
            return false;
        }
        return stack.empty();
    }
}
// @lc code=end

