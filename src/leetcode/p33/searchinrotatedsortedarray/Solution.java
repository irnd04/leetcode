package leetcode.p33.searchinrotatedsortedarray;

class Solution {
    public int search(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int search = new Solution().search(new int[]{4, 5, 6, 7, 0, 1, 2}, 9);
        System.out.println(search);
    }
}