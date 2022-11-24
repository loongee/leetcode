import java.util.*;

/*
 * @lc app=leetcode id=648 lang=java
 *
 * [648] Replace Words
 */

// @lc code=start

class Trie {
    String fullString;
    boolean isLeaf;
    Trie[] children = new Trie[26];

    void insertString(String str) { 
        Trie curNode = this;
        for(int index = 0; index < str.length(); ++index) {
            char ch = str.charAt(index);
            Trie childNode = curNode.children[ch - 'a'];
            if (childNode == null) {
                childNode = new Trie();
                curNode.children[ch - 'a'] = childNode;
            } else if (childNode.isLeaf) {
                return;
            }
            curNode = childNode;
        }
        curNode.isLeaf = true;
        curNode.fullString = str;
    }

    String searchString(String str, int start, int end) {
        Trie curNode = this;
        for (int i = start; i < end; ++i) {
            char ch = str.charAt(i);
            Trie childNode = curNode.children[ch - 'a'];
            if (childNode == null) {
                return str.substring(start, end);
            } else if (childNode.isLeaf) {
                return childNode.fullString;
            }
            curNode = childNode;
        }
        return str.substring(start, end);
    }
}

class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie();
        for (String word : dictionary) {
            trie.insertString(word);
        }

        StringBuilder sb = new StringBuilder(sentence.length());

        int start = 0;
        for (int i = 0; i <= sentence.length(); ++i) {
            if (i == sentence.length() || sentence.charAt(i) == ' ') {
                Trie curNode = trie;
                boolean match = false;
                for (int index = start; index < i; ++index) {
                    char ch = sentence.charAt(index);
                    Trie childNode = curNode.children[ch - 'a'];
                    if (childNode == null) {
                        break;
                    } else if (childNode.isLeaf) {
                        match = true;
                        sb.append(childNode.fullString);
                        break;
                    }
                    curNode = childNode;
                }
                if (!match) {
                    sb.append(sentence.substring(start, i));
                }
                start = i + 1;

                if (i != sentence.length()) {
                    sb.append(' ');
                }
            }
        }
        
        return sb.toString();
    }
}
// @lc code=end

