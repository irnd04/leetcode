package leetcode.p4.medianoftwosortedarrays;

import java.util.ArrayList;
import java.util.Collections;

public class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        ArrayList<Integer> li = new ArrayList<>(nums1.length + nums2.length + 10);
        for (int i = 0; i < nums1.length; i++) {
            li.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            li.add(nums2[i]);
        }
        Collections.sort(li);

        if (li.size() % 2 == 1) {
            return li.get(li.size() / 2);
        }

        int sum = li.get(li.size() / 2) + li.get((li.size() / 2) - 1);
        return (double) sum / 2;
    }

    public static void main(String[] args) {
        double medianSortedArrays = new Solution().findMedianSortedArrays(new int[]{1, 3}, new int[]{2});
        System.out.println(medianSortedArrays);
        medianSortedArrays = new Solution().findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4});
        System.out.println(medianSortedArrays);
    }

}
