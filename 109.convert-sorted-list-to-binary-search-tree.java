import java.util.ArrayList;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=109 lang=java
 *
 * [109] Convert Sorted List to Binary Search Tree
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    ListNode gHead;

    public TreeNode sortedListToBST(ListNode head) {
        gHead = head;
        int size = getListSize();
        return buildTree(0, size - 1);
    }

    private int getListSize() {
        int i = 0;
        ListNode head = gHead;
        while (head != null) {
            ++i;
            head = head.next;
        }
        return i;
    }

    private TreeNode buildTree(int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = (left + right + 1) / 2;
        TreeNode leftNode = buildTree(left, mid - 1);
        TreeNode curNode = new TreeNode(gHead.val);
        gHead = gHead.next;
        curNode.left = leftNode;
        curNode.right = buildTree(mid + 1, right);
        return curNode;
    }
}
// @lc code=end

