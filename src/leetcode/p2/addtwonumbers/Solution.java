package leetcode.p2.addtwonumbers;

import java.math.BigInteger;
import java.sql.SQLOutput;
import java.util.LinkedList;

public class Solution {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public BigInteger nodeToBigInt(ListNode li) {
        BigInteger sum = BigInteger.ZERO;
        BigInteger mul = BigInteger.ONE;
        while (li != null) {
            sum = sum.add(BigInteger.valueOf(li.val).multiply(mul));
            li = li.next;
            mul = mul.multiply(BigInteger.TEN);
        }
        return sum;
    }

    public ListNode bigIntToNode(BigInteger bigInteger) {
        LinkedList<Integer> stack = new LinkedList<>();
        for (char ch : bigInteger.toString().toCharArray()) {
            stack.push(ch - '0');
        }

        ListNode r = new ListNode();
        ListNode cur = r;
        while (!stack.isEmpty()) {
            cur.next = new ListNode(stack.pop());
            cur = cur.next;
        }
        return r.next;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        BigInteger result = nodeToBigInt(l1).add(nodeToBigInt(l2));
        return bigIntToNode(result);
    }

    public static void main(String[] args) {
        // write your code here
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));

        new Solution().addTwoNumbers(l1, l2);

    }

}

