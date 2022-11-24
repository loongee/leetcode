/*
 * @lc app=leetcode id=68 lang=java
 *
 * [68] Text Justification
 */

// @lc code=start
import java.util.*;
class Solution {
    public static void main(String[] args) {
        Solution sl = new Solution();
        sl.fullJustify(new String[]{"What","must","be","acknowledgment","shall","be"}, 16);
    }
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();

        int wordsLen = 0;
        int start = 0;
        for (int i = 0; i < words.length; ++i) {
            if (words[i].length() + wordsLen + (i - start) <= maxWidth) {
                wordsLen += words[i].length();
            } else {
                if (start == i - 1) {
                    result.add(joinLineLeftJustify(words, start, i, wordsLen, maxWidth));
                } else {
                    result.add(joinToLine(words, start, i, wordsLen, maxWidth));
                }
                wordsLen = words[i].length();
                start = i;
            }
        }
        if (start < words.length) {
            result.add(joinLineLeftJustify(words, start, words.length, wordsLen, maxWidth));
        }

        return result;
    }

    private String joinLineLeftJustify(String[] words, int start, int end, int wordsLen, int maxWidth) {
        StringBuilder sb = new StringBuilder(maxWidth);
        for (int i = start; i < end; ++i) {
            sb.append(words[i]);
            if (sb.length() < maxWidth) {
                sb.append(' ');
            }
        }
        while (sb.length() < maxWidth) {
            sb.append(' ');
        }
        return sb.toString();
    }

    private String joinToLine(String[] words, int start, int end, int wordsLen, int maxWidth) {
        StringBuilder sb = new StringBuilder(maxWidth);
        int extraSpaces = (maxWidth - wordsLen) % (end - start - 1);
        int evenSpace = (maxWidth - wordsLen) / (end - start - 1);
        for (int i = start; i < end; ++i) {
            sb.append(words[i]);

            if (i != end - 1) {
                for (int j = 0; j < evenSpace; ++j) {
                    sb.append(' ');
                }
                if (i - start < extraSpaces) {
                    sb.append(' ');
                }
            }
        }
        return sb.toString();
    }
}
// @lc code=end

