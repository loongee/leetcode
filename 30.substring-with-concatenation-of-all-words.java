/*
 * @lc app=leetcode id=30 lang=java
 *
 * [30] Substring with Concatenation of All Words
 */

// @lc code=start
import java.util.*;
class Solution {
    public static void main(String[] args) {
        Solution sl = new Solution();
        sl.findSubstring("ababababab", new String[]{"ababa","babab"});
    }

    public List<Integer> findSubstring(String s, String[] words) {
        Map<String, Integer> occusionMap = new HashMap<>();
        for (String word : words) {
            occusionMap.put(word, occusionMap.getOrDefault(word, 0) + 1);
        }

        List<Integer> result = new ArrayList<>();
        int wordLen = words[0].length();

        if (s.length() < wordLen * words.length) {
            return result;
        }

        for (int i = 0; i < wordLen; ++i) {
            Map<String, Integer> localMap = new HashMap<>();
            localMap.putAll(occusionMap);

            if (i + wordLen * words.length > s.length()) {
                break;
            }

            for (int j = 0; j < words.length; ++j) {
                String curWord = s.substring(i + j * wordLen, i + (j + 1) * wordLen);
                localMap.put(curWord, localMap.getOrDefault(curWord, 0) - 1);
                if (localMap.get(curWord) == 0) {
                    localMap.remove(curWord);
                }
            }

            if (localMap.isEmpty()) {
                result.add(i);
            }

            for (int j = i + wordLen * words.length; j + wordLen <= s.length(); j += wordLen) {
                int startIndex = j - wordLen * words.length;
                String startWord = s.substring(startIndex, startIndex + wordLen);
                localMap.put(startWord, localMap.getOrDefault(startWord, 0) + 1);
                if (localMap.get(startWord) == 0) {
                    localMap.remove(startWord);
                }
                String curWord = s.substring(j, j + wordLen);
                localMap.put(curWord, localMap.getOrDefault(curWord, 0) - 1);
                if (localMap.get(curWord) == 0) {
                    localMap.remove(curWord);
                }
                if (localMap.isEmpty()) {
                    result.add(startIndex + wordLen);
                }
            }
        }

        return result;
    }
}
// @lc code=end

