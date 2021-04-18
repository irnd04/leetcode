package leetcode.p17.lettercombinationsofaphonenumber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    ArrayList<Character>[] strings = new ArrayList[10];
    char[] chars;
    int[] arr;
    int N;
    List<String> results = new ArrayList<>();

    public void solve(int i) {
        if (i == N) {
            String s = new String(chars);
            results.add(s);
            return;
        }

        for (char ch : strings[arr[i]]) {
            chars[i] = ch;
            solve(i + 1);
        }
    }

    public List<String> letterCombinations(String digits) {
        strings[2] = new ArrayList<Character>(Arrays.asList('a', 'b', 'c'));
        strings[3] = new ArrayList<Character>(Arrays.asList('d', 'e', 'f'));
        strings[4] = new ArrayList<Character>(Arrays.asList('g', 'h', 'i'));
        strings[5] = new ArrayList<Character>(Arrays.asList('j', 'k', 'l'));
        strings[6] = new ArrayList<Character>(Arrays.asList('m', 'n', 'o'));
        strings[7] = new ArrayList<Character>(Arrays.asList('p', 'q', 'r', 's'));
        strings[8] = new ArrayList<Character>(Arrays.asList('t', 'u', 'v'));
        strings[9] = new ArrayList<Character>(Arrays.asList('w', 'x', 'y', 'z'));

        chars = digits.toCharArray();
        arr = new int[chars.length];
        N = arr.length;
        if (N == 0) return results;

        for (int i = 0; i < chars.length; i++)
            arr[i] = chars[i] - '0';
        solve(0);

        return results;
    }

    public static void main(String[] args) {
        new Solution().letterCombinations("");
    }

}