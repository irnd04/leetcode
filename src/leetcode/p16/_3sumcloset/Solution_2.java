package leetcode.p16._3sumcloset;

import java.net.SocketTimeoutException;
import java.util.Arrays;

public class Solution_2 {

    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);

        int result = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int lo = i + 1;
            int hi = nums.length - 1;
            while (lo < hi) {
                int sum = nums[i] + nums[lo] + nums[hi];
                if (Math.abs(target - result) > Math.abs(target - sum)) {
                    result = sum;
                }
                if (sum < target) {
                    lo++;
                } else {
                    hi--;
                }
            }
        }

        return result;

    }

    public static void main(String[] args) {
        int i = new Solution_2().threeSumClosest(new int[]{0, 2, 1, -3}, 1);
        System.out.println(i);
    }
}