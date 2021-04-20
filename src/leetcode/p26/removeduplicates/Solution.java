package leetcode.p26.removeduplicates;

class Solution {
    public int removeDuplicates(int[] nums) {
        int lo = 0;
        int hi = 0;
        while (hi < nums.length) {
            nums[lo++] = nums[hi];
            int ohi = hi;
            while (hi < nums.length && nums[ohi] == nums[hi]) hi++;
        }

        return lo;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4, 4, 4, 4, 4};
        int n = new Solution().removeDuplicates(nums);

        for (int i = 0; i < n; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

}