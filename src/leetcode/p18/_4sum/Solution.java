package leetcode.p18._4sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> results = new ArrayList<>();

        Set<List<Integer>> set = new HashSet<>();

        Arrays.sort(nums);

//        System.out.println(Arrays.toString(nums));

        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                int lo = j + 1;
                int hi = nums.length - 1;
                while (lo < hi) {
                    int sum = nums[i] + nums[j] + nums[lo] + nums[hi];

                    if (sum == target) {
                        List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[lo], nums[hi]);
                        if (!set.contains(temp)) {
                            results.add(temp);
                            set.add(temp);
                        }
                    }

                    if (sum < target) {
                        lo++;
                    } else hi--;
                }
            }
        }
        return results;
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new Solution().fourSum(new int[]{-2, -1, -1, 1, 1, 2, 2}, 0);
        List<List<Integer>> lists2 = new Solution().fourSum(new int[]{-2, -1, -1, 1, 1, 2, 2}, 0);
        System.out.println(lists.equals(lists2));
        System.out.println(lists);
    }
}