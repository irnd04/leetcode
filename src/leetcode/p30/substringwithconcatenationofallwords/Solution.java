package leetcode.p30.substringwithconcatenationofallwords;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {


    public List<Integer> findSubstring(String s, String[] words) {

        List<Integer> result = new ArrayList<>();

        int len = words[0].length();

        Map<String, Integer> map = new HashMap<>();
        Arrays.stream(words).forEach(w -> {
            map.put(w, map.getOrDefault(w, 0) + 1);
        });

        for (int i = 0; i < s.length() - (len * words.length) + 1; i++) {
            Map<String, Integer> currMap = new HashMap<>();
            for (int j = i, count = 0; j < s.length() - len + 1 && count < words.length; j += len, count++) {
                String curr = s.substring(j, j + len);
                currMap.put(curr, currMap.getOrDefault(curr, 0) + 1);
            }
            if (map.equals(currMap)) {
                result.add(i);
            }
        }

        return result;

    }

    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 10000; i++) {
            stringBuilder.append("1");
        }
        String s = stringBuilder.toString();
        String[] words = new String[5000];
        for (int i = 0; i < 5000; i++) {
            words[i] = "1";
        }

        long l = System.currentTimeMillis();

        List<Integer> li = new Solution().findSubstring(s, words);
        System.out.println(System.currentTimeMillis() - l);
    }

}