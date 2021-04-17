package leetcode.p5.longestpalindromicsubstring;

class Solution {

    public int check(String s, int start, int end) {
        int r = end - start + 1;
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end))
                return 0;
            start++;
            end--;
        }
        return r;
    }

    public String longestPalindrome(String s) {
        int n = s.length();
        int max = 0;
        int[] result = new int[2];

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (j - i + 1 <= max)
                    continue;
                int c = check(s, i, j);
                if (c > max) {
                    result[0] = i;
                    result[1] = j;
                    max = c;
                }
            }
        }
        return s.substring(result[0], result[1] + 1);
    }

    public static void main(String[] args) {
        new Solution().longestPalindrome("zaba");
    }
}
