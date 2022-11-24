import java.util.Arrays;

/*
 * @lc app=leetcode id=17 lang=java
 *
 * [17] Letter Combinations of a Phone Number
 */

// @lc code=start
import java.util.*;
class Solution {
    static List<List<Character>> chrs = Arrays.asList(
        Arrays.asList('a', 'b', 'c'),
        Arrays.asList('d', 'e', 'f'),
        Arrays.asList('g', 'h', 'i'),
        Arrays.asList('j', 'k', 'l'),
        Arrays.asList('m', 'n', 'o'),
        Arrays.asList('p', 'q', 'r', 's'),
        Arrays.asList('t', 'u', 'v'),
        Arrays.asList('w', 'x', 'y', 'z')
    );

    public List<String> letterCombinations(String digits) {
        List<String> strs = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        if (digits.length() == 0) {
            return strs;
        }
        letterCombinationsRecursive(sb, digits, 0, strs);
        return strs;
    }

    public void letterCombinationsRecursive(StringBuilder sb, String digits, int offset, List<String> strs) {
        if (offset == digits.length()) {
            strs.add(sb.toString());
            return;
        }

        List<Character> curList = chrs.get(digits.charAt(offset) - '2');
        for (int i = 0; i < curList.size(); ++i) {
            int oldLen = sb.length();
            sb.append(curList.get(i));
            letterCombinationsRecursive(sb, digits, offset + 1, strs);
            sb.deleteCharAt(oldLen);
        }
    }
}
// @lc code=end

