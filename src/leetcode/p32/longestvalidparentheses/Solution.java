package leetcode.p32.longestvalidparentheses;

import java.util.LinkedList;

class Solution {

    public int longestValidParentheses(String s) {

        int open = -1;
        int close = -2;

        LinkedList<Integer> stack = new LinkedList<>();

        for (int ch : s.toCharArray()) {

            if (ch == '(')
                ch = open;
            if (ch == ')')
                ch = close;

            if (stack.isEmpty() || ch == open) {
                stack.push(ch);
                continue;
            }

            if (ch == close) {
                int sum = 0;
                while (true) {
                    if (stack.isEmpty()) {
                        stack.push(sum);
                        stack.push(ch);
                        break;
                    }
                    int before = stack.peek();
                    if (before == open) {
                        stack.pop();
                        stack.push(2 + sum);
                        break;
                    }
                    if (before == close) {
                        if (sum > 0)
                            stack.push(sum);
                        stack.push(ch);
                        break;
                    }
                    sum += before;
                    stack.pop();
                }
            }
        }


        if (stack.isEmpty()) {
            return 0;
        }

//        System.out.println(stack);

        int sum = 0;
        int result = 0;

        while (!stack.isEmpty()) {
            int cur = stack.pop();
            if (cur < 0) {
                sum = 0;
                continue;
            }
            sum += cur;
            result = Math.max(sum, result);
        }

//        System.out.println(result);

        return result;
    }

    public static void main(String[] args) {
        new Solution().longestValidParentheses("");
    }

}
