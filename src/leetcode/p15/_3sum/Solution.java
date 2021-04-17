package leetcode.p15._3sum;

import java.util.*;

public class Solution {

    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        Map<Integer, Integer> countMap = new HashMap<>();
        Set<String> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            countMap.put(nums[i], countMap.getOrDefault(nums[i], 0) + 1);
        }

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                int t = 0 - (nums[i] + nums[j]);
                if (t >= nums[j] &&
                        !set.contains(nums[i] + "$" + nums[j])) {
                    int c = 1;
                    if (nums[j] == t) {
                        c++;
                        if (nums[i] == nums[j])
                            c++;
                    }

                    if (countMap.containsKey(t) && countMap.get(t) >= c) {
                        result.add(Arrays.asList(nums[i], nums[j], t));
                        set.add(nums[i] + "$" + nums[j]);
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // new Solution().threeSum(new int[] {-1, 0, 1, 2, -1, -4});
        new Solution().threeSum(new int[] {});
        new Solution().threeSum(new int[] {0});
    }

}
