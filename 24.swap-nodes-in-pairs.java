/*
 * @lc app=leetcode id=24 lang=java
 *
 * [24] Swap Nodes in Pairs
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
    public ListNode swapPairs(ListNode head) {
        ListNode ret = head;
        if (head != null && head.next != null) {
            ret = head.next;
        }

        // start reverse pairs
        ListNode first = head;
        ListNode second = null;
        ListNode prevTail = head;
        while (first != null) {
            second = first.next;
            if (second == null) {
                break;
            }

            ListNode nextFirst = second.next;

            // begin swap
            prevTail.next = second;
            first.next = nextFirst;
            second.next = first;

            // prepare for next swap
            prevTail = first;
            first = nextFirst;
        }
        return ret;
    }
}
// @lc code=end

