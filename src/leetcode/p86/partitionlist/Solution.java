package leetcode.p86.partitionlist;

import leetcode.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public ListNode partition(ListNode head, int x) {
        List<Integer> less = new ArrayList<>();
        List<Integer> gte = new ArrayList<>();

        while (head != null) {
            if (head.val < x)
                less.add(head.val);
            else gte.add(head.val);
            head = head.next;
        }

        less.addAll(gte);

        ListNode cur = new ListNode();
        ListNode r = cur;
        for (int v : less) {
            cur.next = new ListNode(v);
            cur = cur.next;
        }

        return r.next;

    }

    public static void main(String[] args) {
        new Solution().partition(ListNode.toListNode(1,4,3,2,5,2), 3);
    }

}