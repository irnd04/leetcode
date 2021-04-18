package leetcode.p21.mergetwosortedlists;

import leetcode.ListNode;

public class Solution {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode cur = new ListNode();
        ListNode result = cur;

        while (true) {
            if (l1 == null) {
                cur.next = l2;
                break;
            } else if (l2 == null) {
                cur.next = l1;
                break;
            }
            if (l1.val < l2.val) {
                cur.next = new ListNode(l1.val);
                cur = cur.next;
                l1 = l1.next;
            } else {
                cur.next = new ListNode(l2.val);
                cur = cur.next;
                l2 = l2.next;
            }
        }

        return result.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new Solution().mergeTwoLists(ListNode.toListNode(), ListNode.toListNode(0));
        System.out.println(listNode);
    }

}
