import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/*
 * @lc app=leetcode id=22 lang=java
 *
 * [22] Generate Parentheses
 */

// @lc code=start
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        generateParenthesisRecursive(result, "(", 1, n);
        return result;
    }

    private void generateParenthesisRecursive(List<String> result, String leftStr, int leftCnt, int n) {
        if (leftCnt > n || leftStr.length() > leftCnt * 2) {
            return;
        }
        if (leftStr.length() == n * 2) {
            result.add(leftStr);
            return;
        }

        generateParenthesisRecursive(result, leftStr + "(", leftCnt + 1, n);
        generateParenthesisRecursive(result, leftStr + ")", leftCnt, n);
    }
}
// @lc code=end

