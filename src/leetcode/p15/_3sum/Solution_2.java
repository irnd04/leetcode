package leetcode.p15._3sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_2 {

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        System.out.println(Arrays.toString(nums));

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int lo = i + 1;
            int hi = nums.length - 1;
            while (lo < hi) {
                int sum = nums[i] + nums[lo] + nums[hi];
                if (sum == 0) {
                    result.add(Arrays.asList(
                            nums[i], nums[lo], nums[hi]));
                    int olo = lo;
                    int ohi = hi;
                    while (lo < nums.length && nums[olo] == nums[lo]) lo++;
                }
                if (sum < 0) {
                    lo++;
                } else hi--;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new Solution_2().threeSum(new int[]{-2, 0, 0, 2, 2});
        System.out.println(lists);
    }

}
