package leetcode.p42.trappingrainwater;

class Solution {

    /*
    다시 풀어야함.

     */

    int[] height;

    public int sum(int l, int r) {
        int min = Math.min(height[l], height[r]);
        int ret = 0;
        for (int i = l + 1; i < r; i++) {
            if (min < height[i])
                continue;
            ret += min - height[i];
            height[i] = min;
        }
        return ret;
    }

    public int trap(int[] height) {
        this.height = height;
        int l = 0;
        int r = 0;
        int bef = 0;
        int sum = 0;

        while (r < height.length) {
            if (height[bef] < height[r]) {
                if (height[l] > 0) {
                    sum += sum(l, r);
                }
                if (height[l] < height[r])
                    l = r;
            }
            bef = r;
            r++;
        }

        return sum;

    }

    public static void main(String[] args) {
        int trap = new Solution().trap(new int[]{4, 2, 0, 3, 2, 5});
        System.out.println(trap);
    }
}