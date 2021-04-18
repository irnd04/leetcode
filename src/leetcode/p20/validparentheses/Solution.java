package leetcode.p20.validparentheses;

import java.util.HashMap;
import java.util.LinkedList;

class Solution {
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        LinkedList<Character> stack = new LinkedList<>();

        HashMap<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');

        for (char ch : chars) {
            if (map.containsKey(ch)) {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) return false;
                if (map.get(stack.pop()) != ch) return false;
            }
        }

        if (stack.isEmpty()) return true;
        return false;
    }
}