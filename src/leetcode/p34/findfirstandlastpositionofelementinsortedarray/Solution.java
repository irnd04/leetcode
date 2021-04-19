package leetcode.p34.findfirstandlastpositionofelementinsortedarray;

import java.util.Arrays;

class Solution {

    public int i = 0;

    public int search(int[] nums, int s, int e, int t) {
        if (s > e) return -1;
        int mid = (s + e) / 2;
        if (nums[mid] < t) {
            return search(nums, mid + 1, e, t);
        }
        if (nums[mid] >= t) {
            i = mid;
            return search(nums, s, mid - 1, t);
        }
        return -1;
    }

    public int search2(int[] nums, int s, int e, int t) {
        if (s > e) return -1;
        int mid = (s + e) / 2;
        if (nums[mid] <= t) {
            i = mid;
            return search2(nums, mid + 1, e, t);
        }
        if (nums[mid] > t) {
            return search2(nums, s, mid - 1, t);
        }
        return -1;
    }

    public int[] searchRange(int[] nums, int target) {
        search(nums, 0, nums.length - 1, target);
        int left = i;
        search2(nums, 0, nums.length - 1, target);
        int right = i;
        if (nums.length == 0 || nums[left] != target)
            return new int[] {-1, -1};
        return new int[] {left, right};
    }

    public static void main(String[] args) {
        int[] ints = new Solution().searchRange(new int[]{}, 0);
        System.out.println(Arrays.toString(ints));
    }


}
