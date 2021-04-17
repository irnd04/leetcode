package leetcode.p11.containerwithmostwater;

public class Solution {

    public boolean inrange(int i, int n) {
        return 0 <= i && i < n;
    }

    public int search(int[] height, int i, int add) {
        int cur = height[i];
        while (inrange(i, height.length)) {
            if (cur < height[i]) return i;
            i += add;
        }
        return i;
    }


    public int maxArea(int[] height) {
        int start = 0;
        int end = height.length - 1;

        int max = 0;

        while (start <= end) {
            int area = (end - start) * Math.min(height[start], height[end]);
            max = Math.max(max, area);
            if (height[start] <= height[end]) {
                start = search(height, start, 1);
            } else {
                end = search(height, end, -1);
            }
        }

        return max;

    }

    public static void main(String[] args) {
        new Solution().maxArea(new int[] {1, 8, 6, 2, 5, 4, 8, 3, 7});
        new Solution().maxArea(new int[] {4, 3, 2, 1, 4});
        new Solution().maxArea(new int[] {1, 1});
    }

}
