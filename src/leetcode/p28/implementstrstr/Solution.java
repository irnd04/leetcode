package leetcode.p28.implementstrstr;

class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.equals("")) return 0;

        int find = -1;

        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            int j = 0;
            for (; j < needle.length(); j++) {
                if (haystack.charAt(j + i) != needle.charAt(j)) break;
            }
            if (j == needle.length()) return i;
        }

        return find;
    }

    public static void main(String[] args) {
        int i = new Solution().strStr("a", "ab");
        System.out.println(i);
    }
}