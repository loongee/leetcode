/*
 * @lc app=leetcode id=60 lang=java
 *
 * [60] Permutation Sequence
 */

// @lc code=start
class Solution {
    public static void main(String[] args) {
        Solution sl = new Solution();
        sl.getPermutation(4, 9);
    }
    public String getPermutation(int n, int k) {
        int curDen = 1;
        k = k - 1;
        char[] arr = new char[n];
        arr[0] = '1';
        for (int i = 1; i < n; ++i) {
            curDen *= i;
            arr[i] = (char)('1' + i);
        }

        curDen *= n;
        for (int i = 0; i < n; ++i) {
            curDen /= (n - i);
            int offset = k / curDen;
            if (offset > 0) {
                char tmp = arr[i + offset];
                for (int j = i + offset; j > i; --j) {
                    arr[j] = arr[j - 1];
                }
                arr[i] = tmp;
            }
            k %= curDen;
        }

        return new String(arr);
    }
}
// @lc code=end

