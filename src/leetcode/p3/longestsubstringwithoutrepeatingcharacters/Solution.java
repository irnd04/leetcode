package leetcode.p3.longestsubstringwithoutrepeatingcharacters;

import java.util.HashSet;
import java.util.Set;

class Solution {

    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int n = s.length();
        int start = 0;
        int end = 0;
        int result = 0;

        while (end < n) {
            if (set.contains(s.charAt(end))) {
                set.remove(s.charAt(start++));
            } else {
                result = Math.max(result, end - start + 1);
                set.add(s.charAt(end++));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        new Solution().lengthOfLongestSubstring("abcabcbb");
    }

}