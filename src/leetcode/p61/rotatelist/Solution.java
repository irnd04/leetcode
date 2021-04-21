package leetcode.p61.rotatelist;

import java.util.ArrayList;
import java.util.List;

import leetcode.ListNode;

class Solution {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;

        ListNode tail = head;
        ListNode cur = head;

        List<ListNode> li = new ArrayList<>();

        while (cur != null) {
            li.add(cur);
            tail = cur;
            cur = cur.next;
        }

        int find = k % li.size();
        if (find == 0) return head;
        /*
        1 .. 3  5 - 1 - 1;
        2 .. 2  5 - 2 - 1;
        3 .. 1  5 - 3 - 1
        4 .. 0  5 - 4 - 1
        */

        cur = li.get(li.size() - find - 1);
        ListNode left = cur.next;
        cur.next = null;
        tail.next = head;

        return left;
    }

    public static void main(String[] args) {
        ListNode listNode = new Solution().rotateRight(ListNode.toListNode(0, 1, 2), 2);
        System.out.println(listNode);

    }
}