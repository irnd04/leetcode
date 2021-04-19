package leetcode.p39.combinationsum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    int[] c;
    int target;
    int[] result = new int[5001];
    List<List<Integer>> lis = new ArrayList<>();

    public void solve(int pos, int s, int sum) {
        if (sum != 0 && sum == target) {
            ArrayList<Integer> li = new ArrayList<>();
            for (int i = 0; i < pos; i++) {
                li.add(result[i]);
            }
            lis.add(li);
            return;
        }

        for (int i = s; i < c.length; i++) {
            int v = c[i];
            if (sum + v <= target) {
                result[pos] = v;
                solve(pos + 1, i, sum + v);
            }
        }

    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.c = candidates;
        this.target = target;
        Arrays.sort(c);
        solve(0, 0, 0);
        return lis;
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new Solution().combinationSum(new int[]{1}, 5002);
        System.out.println(lists);
    }
}