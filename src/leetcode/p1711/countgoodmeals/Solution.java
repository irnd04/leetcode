package leetcode.p1711.countgoodmeals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public void pop(Map<Integer, Integer> countMap, int v) {
        Integer c = countMap.get(v);
        c--;
        if (c == 0) {
            countMap.remove(v);
        } else {
            countMap.put(v, c);
        }
    }


    public int countPairs(int[] deliciousness) {

        final int max = 2097152;
        long result = 0;

        List<Integer> li = new ArrayList<>();

        int sum = 1;
        while (sum <= max) {
            li.add(sum);
            sum *= 2;
        }

        Map<Integer, Integer> countMap = new HashMap<>();
        for (int v : deliciousness) {
            countMap.put(v, countMap.getOrDefault(v,0) + 1);
        }

        for (int i = 0; i < deliciousness.length; i++) {
            int d = deliciousness[i];
            pop(countMap, d);
            for (int p : li) {
                int x = p - d;
                if (x >= 0) {
                    result += countMap.getOrDefault(x, 0);
                    result = result % 1000000007;
                }
            }

        }

        return (int) result;
    }


    public static void main(String[] args) {
        int i = new Solution().countPairs(new int[]{1048576, 1048576});
        System.out.println(i);
    }

}
