package leetcode.p125.validpalindrome;

class Solution {

    public boolean isValid(char ch) {
        return Character.isAlphabetic(ch) || Character.isDigit(ch);
    }

    public boolean isPalindrome(String s) {
        if (s.length() == 1) return true;
        char[] chars = s.toCharArray();
        int lo = -1;
        int hi = chars.length;

        while (true) {
            while ((lo + 1) < chars.length && !isValid(chars[++lo]));
            while ((hi - 1) >= 0 && !isValid(chars[--hi]));
            if (lo > hi) break;
            if (Character.toLowerCase(chars[lo]) !=
                    Character.toLowerCase(chars[hi])) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        new Solution().isPalindrome("race a car");
    }
}