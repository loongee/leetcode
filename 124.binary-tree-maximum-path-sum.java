import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=124 lang=java
 *
 * [124] Binary Tree Maximum Path Sum
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int maxNum = 0;

    public int maxPathSum(TreeNode root) {
        maxNum = root.val;
        maxPathSumRecursive(root);
        return maxNum;
    }

    private int maxPathSumRecursive(TreeNode node) {
        if (node == null) {
            return Integer.MIN_VALUE;
        }
        int leftMax = maxPathSumRecursive(node.left);
        int rightMax = maxPathSumRecursive(node.right);

        int rootMax = node.val;
        if (leftMax > 0) {
            rootMax += leftMax;
        }
        if (rightMax > 0) {
            rootMax += rightMax;
        }
        if (rootMax > maxNum) {
            maxNum = rootMax;
        }

        int singleMax = node.val;
        int maxChild = leftMax > rightMax ? leftMax : rightMax;
        if (maxChild > 0) {
            singleMax += maxChild;
        }
        return singleMax;
    }
}
// @lc code=end

