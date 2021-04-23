package leetcode.p76.minimumwindowsubstring;

import java.util.Map;

public class Solution2 {

    int[] hash = new int[256];
    static final int EMPTY = -99;

    public String minWindow(String s, String t) {

        int sL = s.length();
        int tL = t.length();

        for (char tc : t.toCharArray()) {
            hash[tc]++;
        }

        int lo = 0;
        int hi = 0;
        int cnt = 0;

        Integer minLen = null;
        int minLo = EMPTY;
        int minHi = EMPTY;

        while (hi < sL) {

            char hiC = s.charAt(hi++);
            if (hash[hiC] > 0) {
                cnt++;
            }
            hash[hiC]--;

            while (cnt == tL) {
                char loC = s.charAt(lo);
                if (minLen == null || minLen > (hi - lo)) {
                    minLen = hi - lo;
                    minHi = hi;
                    minLo = lo;
                }
                if (hash[loC] >= 0) {
                    cnt--;
                }
                hash[loC]++;
                lo++;
            }

            if (hi >= sL) break;

        }

        if (minLen == null) return "";

        return s.substring(minLo, minHi);

    }

    public static void main(String[] args) {
        String s = new Solution2().minWindow("bba", "ab");
        System.out.println(s);
    }

}
