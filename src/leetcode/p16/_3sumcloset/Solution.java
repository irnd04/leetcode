package leetcode.p16._3sumcloset;


import java.util.Arrays;

class Solution {

    public int search(int[] nums, int lo, int hi, int target) {
        int mid = -1;
        int olo = lo;
        int ohi = hi;
        while (lo <= hi) {
            mid = (lo + hi) / 2;
            if (nums[mid] < target) {
                lo = mid + 1;
            } else if (nums[mid] > target) {
                hi = mid - 1;
            } else return mid;
        }

        int min = -1;

        for (int fi : new int[] {lo - 1, lo}) {
            if (olo <= fi && fi <= ohi) {
                min = fi;
            }
        }

        for (int fi : new int[] {lo - 1, lo}) {
            if (olo <= fi && fi <= ohi) {
                if (Math.abs(target - nums[min])
                        > Math.abs(target - nums[fi])) {
                    min = fi;
                }
            }
        }

        return min;


    }

    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);

        int result = nums[0] + nums[1] + nums[2];

        for (int i = 1; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int sum = nums[i] + nums[j];
                sum += nums[search(nums, 0, i - 1, target - sum)];
                if (Math.abs(target - result) > Math.abs(target - sum)) {
                    result = sum;
                }
            }
        }

        System.out.println(result);

        return result;
    }

    public static void main(String[] args) {
        new Solution().threeSumClosest(new int[] {-1, 2, 1, -4}, 1);
    }
}