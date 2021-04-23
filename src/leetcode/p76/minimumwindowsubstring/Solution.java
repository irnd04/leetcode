package leetcode.p76.minimumwindowsubstring;

import java.util.HashMap;
import java.util.Map;

class Solution {

    public static class Result {
        int lo;
        int hi;

        public Result(int lo, int hi) {
            this.lo = lo;
            this.hi = hi;
        }

        public int r() {
            return hi - lo;
        }

        public String toString(char[] chars) {
            String s = "";
            for (int i = lo; i < hi; i++) {
                s += chars[i];
            }
            return s;
        }

    }

    private boolean isOk(Map<Character, Integer> sm, Map<Character, Integer> tm) {
        for (Character k : tm.keySet()) {
            if (sm.getOrDefault(k, 0) < tm.get(k)) {
                return false;
            }
        }
        return true;
    }


    public String minWindow(String s, String t) {
        Map<Character, Integer> sm = new HashMap<>();
        Map<Character, Integer> tm = new HashMap<>();

        char[] chars = s.toCharArray();
        int N = chars.length;

        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            tm.put(ch, tm.getOrDefault(ch, 0) + 1);
        }

        Result result = null;

        int lo = 0; int hi = 0;

        while (true) {

            while (hi < N && !isOk(sm, tm)) {
                sm.put(chars[hi], sm.getOrDefault(chars[hi], 0) + 1);
                hi++;
            }

            while (isOk(sm, tm)) {

                if (result == null || result.r() > (hi - lo)) {
                    result = new Result(lo, hi);
                }

                sm.put(chars[lo], sm.get(chars[lo]) - 1);
                lo++;
            }

            if (hi == N)
                break;
        }

        if (result == null) return "";
        return result.toString(chars);
    }

    public static void main(String[] args) {
        new Solution().minWindow("a", "aa");
    }

}