import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=23 lang=java
 *
 * [23] Merge k Sorted Lists
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
// public class ListNode {
//          int val;
//          ListNode next;
//          ListNode() {}
//         ListNode(int val) { this.val = val; }
//         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//  }

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        return partionLists(lists, 0, lists.length - 1);
    }

    public ListNode partionLists(ListNode[] lists, int start, int end) {
        if (start == end) return lists[start];
        if (start == end - 1) {
            return merge2List(lists[start], lists[start + 1]);
        }
        int q = (start + end) / 2;
        return merge2List(partionLists(lists, start, q), partionLists(lists, q + 1, end));
    }

    public ListNode merge2List(ListNode lst1, ListNode lst2) {
        if (lst1 == null) {
            return lst2;
        }
        if (lst2 == null) {
            return lst1;
        }

        ListNode head;

        ListNode tail;

        if (lst1.val < lst2.val) {
            head = lst1;
            tail = lst1;
            lst1 = lst1.next;
        } else {
            head = lst2;
            tail = lst2;
            lst2 = lst2.next;
        }
        
        while (lst1 != null && lst2 != null) {
            if (lst1.val < lst2.val) {
                tail.next = lst1;
                tail = lst1;
                lst1 = lst1.next;
            } else {
                tail.next = lst2;
                tail = lst2;
                lst2 = lst2.next;
            }
        }

        if (lst1 != null) {
            tail.next = lst1;
        } else {
            tail.next = lst2;
        }
        return head;
    }
}
// @lc code=end

