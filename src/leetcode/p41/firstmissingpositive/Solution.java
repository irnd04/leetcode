package leetcode.p41.firstmissingpositive;

import java.util.*;

public class Solution {

    public int firstMissingPositive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int v = nums[i];
            if (v > 0) set.add(v);
        }
        List<Integer> li = new ArrayList<>(set);
        Collections.sort(li);
        int bef = 0;
        for (int v : li) {
            if (bef + 1 != v) {
                return bef + 1;
            }
            bef = v;
        }
        return bef + 1;
    }

    public static void main(String[] args) {
        int i = new Solution().firstMissingPositive(new int[]{0});
        System.out.println(i);
    }


}
