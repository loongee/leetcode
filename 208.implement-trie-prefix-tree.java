/*
 * @lc app=leetcode id=208 lang=java
 *
 * [208] Implement Trie (Prefix Tree)
 */

// @lc code=start
class Trie {
    boolean isLeaf;
    Trie[] children = new Trie[26];

    public Trie() {
        
    }
    
    public void insert(String word) {
        Trie curNode = this;
        for(int index = 0; index < word.length(); ++index) {
            char ch = word.charAt(index);
            Trie childNode = curNode.children[ch - 'a'];
            if (childNode == null) {
                childNode = new Trie();
                curNode.children[ch - 'a'] = childNode;
            }
            curNode = childNode;
        }
        curNode.isLeaf = true;
        
    }
    
    public boolean search(String word) {
        Trie curNode = this;
        for (int i = 0; i < word.length(); ++i) {
            char ch = word.charAt(i);
            Trie childNode = curNode.children[ch - 'a'];
            if (childNode == null) {
                return false;
            }
            curNode = childNode;
        }
        return curNode.isLeaf;
    }
    
    public boolean startsWith(String prefix) {
        Trie curNode = this;
        for (int i = 0; i < prefix.length(); ++i) {
            char ch = prefix.charAt(i);
            Trie childNode = curNode.children[ch - 'a'];
            if (childNode == null) {
                return false;
            }
            curNode = childNode;
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
// @lc code=end

