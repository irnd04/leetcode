package leetcode.p22.generateparentheses;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    int n;
    char[] arr;
    List<String> result = new ArrayList<>();

    public void solve(int i, int open) {

        if (i == n * 2) {
            if (open == 0)
                result.add(new String(arr));
            return;
        }
        arr[i] = '(';
        solve(i + 1, open + 1);
        if (open > 0) {
            arr[i] = ')';
            solve(i + 1, open - 1);
        }
    }

    public List<String> generateParenthesis(int n) {
        this.n = n;
        arr = new char[n * 2];
        solve(0, 0);
        return result;
    }

    public static void main(String[] args) {
        new Solution().generateParenthesis(1);
    }
}