package leetcode.p23.mergeksortedlists;

import leetcode.ListNode;

public class Solution {

    private ListNode[] lists;

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

    public ListNode merge(int left, int right) {
        if (right - left == 1) {
            return mergeTwoLists(lists[left], lists[right]);
        }
        if (right == left) {
            return lists[right];
        }

        int mid = (left + right) / 2;
        ListNode rNode = merge(mid, right);
        ListNode lNode = merge(left, mid - 1);
        return mergeTwoLists(lNode, rNode);
    }

    public ListNode mergeKLists(ListNode[] lists) {
        this.lists = lists;
        if (lists.length == 0)
            return null;
        if (lists.length == 1)
            return lists[0];
        return merge(0, lists.length - 1);
    }

//    public static void main(String[] args) {
//
//        ListNode[] nodes = new ListNode[] {
//            ListNode.toListNode(1,2, 3)
//        };
//
//        ListNode listNode = new Solution().mergeKLists(nodes);
//        System.out.println(listNode);
//    }

}

