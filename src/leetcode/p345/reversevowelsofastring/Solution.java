package leetcode.p345.reversevowelsofastring;

import java.util.Arrays;

class Solution {

    public boolean valid(char ch) {
        return Arrays.asList('a', 'e', 'i', 'o', 'u')
                .contains(Character.toLowerCase(ch));
    }

    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();

        int lo = 0;
        int hi = chars.length - 1;


        while (true) {
            while (lo < chars.length && !valid(chars[lo])) lo++;
            while (hi >= 0 && !valid(chars[hi])) hi--;

            if (lo > hi) break;
            char temp = chars[lo];
            chars[lo] = chars[hi];
            chars[hi] = temp;
            lo++;
            hi--;
        }

        return new String(chars);

    }

    public static void main(String[] args) {
        String hello = new Solution().reverseVowels("hzllo");
        System.out.println(hello);
    }
}