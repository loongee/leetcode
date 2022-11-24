/*
 * @lc app=leetcode id=25 lang=java
 *
 * [25] Reverse Nodes in k-Group
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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        if (k == 1) {
            return head;
        }

        ListNode ret = head;

        // start reverse pairs
        ListNode curHead = head;
        ListNode prevTail = null;
        while (curHead != null) {
            ListNode curTail = curHead;
            int i = 0;
            for (; i < k - 1 && curTail != null; ++i) {
                curTail = curTail.next;
            }

            if (i != k - 1 || curTail == null) {
                break;
            }

            ListNode nextHead = curTail.next;

            // begin swap
            if (prevTail != null) {
                prevTail.next = curTail;
            } else {
                ret = curTail;
            }
            reverseGroup(curHead, curTail);

            // prepare for next swap
            prevTail = curHead;
            curHead.next = nextHead;
            curHead = nextHead;
        }
        return ret;
    }

    public void reverseGroup(ListNode begin, ListNode end) {
        ListNode cur = begin;
        ListNode next = cur.next;
        while (cur != end) {
            ListNode nextNext = next.next;
            next.next = cur;
            cur = next;
            next = nextNext;
        }
    }
}
// @lc code=end

