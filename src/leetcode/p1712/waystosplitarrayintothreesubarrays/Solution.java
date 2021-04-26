package leetcode.p1712.waystosplitarrayintothreesubarrays;

import java.util.Arrays;

// https://leetcode.com/problems/ways-to-split-array-into-three-subarrays/discuss/999113/JavaScala-Detailed-Explanation-Prefix-Sum-Binary-Search
// 참고해서 코드 수정 필요

public class Solution {

    // 잘라지는 가장 큰수
    public int maxBs(int[] sums, int[] nums, int lo, int hi) {

        int l = lo;
        int r = hi;

        int left = sums[lo - 1];
        while (lo <= hi) {
            int i = (lo + hi) / 2;
            int mid = sums[i] - left;
            int right = sums[sums.length - 1] - sums[i];
            if (left > mid) {
                lo = i + 1;
            } else if (mid <= right) {
                lo = i + 1;
            } else hi = i - 1;
        }

        for (int i : Arrays.asList(lo, lo - 1, lo - 2)) {
            if (!(l <= i && i <= r)) continue;
            int mid = sums[i] - left;
            int right = sums[sums.length - 1] - sums[i];
            if (left <= mid && mid <= right) return i;
        }

        return -1;
    }

    // 잘라지는 가장 작은수
    public int minBs(int[] sums, int[] nums, int lo, int hi) {
        int l = lo;
        int r = hi;
        int left = sums[lo - 1];
        while (lo <= hi) {
            int i = (lo + hi) / 2;
            int mid = sums[i] - left;
            int right = sums[sums.length - 1] - sums[i];
            if (left <= mid && mid <= right) {
                hi = i - 1;
            } else lo = i + 1;
        }

        for (int i : Arrays.asList(hi, hi + 1, hi + 2)) {
            if (!(l <= i && i <= r)) continue;
            int mid = sums[i] - left;
            int right = sums[sums.length - 1] - sums[i];
            if (left <= mid && mid <= right) return i;
        }

        return -1;
    }

    public int waysToSplit(int[] nums) {
        int[] sums = new int[nums.length];
        sums[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int v = nums[i];
            sums[i] = sums[i - 1] + v;
        }

        int result = 0;

        for (int i = 1; i < nums.length - 1; i++) {
            int r = maxBs(sums, nums, i, nums.length - 2);
            if (r == -1) continue;
            int l = minBs(sums, nums, i, r);
            result += (r - l) + 1;
            result %= 1000000007;
            // System.out.println((i - 1) + ", " + l + ", " + r);
        }

        // System.out.println(result);

        return result;
    }

    public static void main(String[] args) {
        // new Solution().waysToSplit(new int[] {1, 2, 2, 2, 5, 0});
        // new Solution().waysToSplit(new int[] {1, 1, 1, 1, 1, 1, 1, 1});
        // new Solution().waysToSplit(new int[] {1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10});
        // new Solution().waysToSplit(new int[] {3, 2, 1});
        // new Solution().waysToSplit(new int[] {1, 1, 3});
        // new Solution().waysToSplit(new int[] {1,2,2,2,5,0});
        new Solution().waysToSplit(new int[] {2, 3, 2, 7, 7, 1, 9, 4});
        // 2 12 21
    }

}
