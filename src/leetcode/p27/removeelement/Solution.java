package leetcode.p27.removeelement;

class Solution {
    public int removeElement(int[] nums, int val) {
        int lo = 0;
        int hi = nums.length - 1;

        while (true) {
            while (lo < nums.length && nums[lo] != val) lo++;
            while (hi > 0 && nums[hi] == val) hi--;
            if (lo >= hi) break;
            int temp = nums[lo];
            nums[lo] = nums[hi];
            nums[hi] = temp;
        }

        return lo;
    }

    public static void main(String[] args) {
        // int[] nums = {3, 3};
        int[] nums = {0,1,2,2,3,0,4,2};
        int n = new Solution().removeElement(nums, 2);

        for (int i = 0; i < n; i++) {
            System.out.println(nums[i] + " ");
        }
        System.out.println();


    }
}