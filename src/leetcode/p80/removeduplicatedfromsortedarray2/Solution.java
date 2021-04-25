package leetcode.p80.removeduplicatedfromsortedarray2;

class Solution {
    public int removeDuplicates(int[] nums) {

        if (nums.length <= 2) {
            return nums.length;
        }

        int lo = 2;
        int hi = 2;
        while (lo < nums.length && hi < nums.length) {
            if (nums[lo - 1] == nums[lo - 2]) {
                if (nums[hi] != nums[lo - 1]) {
                    nums[lo++] = nums[hi];
                }
            } else {
                nums[lo++] = nums[hi];
            }
            hi++;
        }

        return lo;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1};
        int len = new Solution().removeDuplicates(nums);
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i]);
        }
        System.out.println();
    }
}
