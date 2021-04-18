package leetcode.p19.removenthnodefromendoflist;

import java.util.ArrayList;

class Solution {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ArrayList<ListNode> li = new ArrayList<>();
        ListNode cursor = head;

        while (cursor != null) {
            li.add(cursor);
            cursor = cursor.next;
        }

        if (n == li.size()) {
            return head.next;
        }

        n = li.size() - n;

        ListNode add = null;
        if (n + 1 < li.size()) {
            add = li.get(n + 1);
        }

        li.get(n - 1).next = add;

        return head;
    }

    ListNode toListNode(int... args) {
        ListNode cur = new ListNode();
        ListNode result = cur;
        for (int i : args) {
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        return result.next;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode listNode = solution.removeNthFromEnd(solution.toListNode(1, 2, 3), 3);
        System.out.println(listNode);
    }
}