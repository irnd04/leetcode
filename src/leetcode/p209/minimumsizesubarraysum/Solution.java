package leetcode.p209.minimumsizesubarraysum;

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        Integer r = null;
        long sum = 0;
        int lo = 0;
        int hi = 0;
        while (lo <= hi && lo < nums.length) {
            if (sum >= target) {
                if (r == null) r = (hi - lo);
                r = Math.min(r, (hi - lo));
            }
            if (sum >= target || hi == nums.length) {
                sum -= nums[lo++];
            } else {
                sum += nums[hi++];
            }
        }

        return r == null ? 0 : r;
    }

    public static void main(String[] args) {
        int i = new Solution().minSubArrayLen(7, new int[]{2,3,1,2,4,3});
        System.out.println(i);
    }
}