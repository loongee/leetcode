/*
 * @lc app=leetcode id=19 lang=java
 *
 * [19] Remove Nth Node From End of List
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
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode retHead = head;

        ListNode tail = head;
        ListNode prev = tail;
        for (int i = 0; i < n; ++i) {
            prev = tail;
            tail = tail.next;
        }

        if (tail == null) {
            return head.next;
        }

        ListNode nodePrevRemove = head;
        while (tail.next != null) {
            tail = tail.next;
            nodePrevRemove = nodePrevRemove.next;
        }

        nodePrevRemove.next = nodePrevRemove.next.next;

        return retHead;
    }
}
// @lc code=end

