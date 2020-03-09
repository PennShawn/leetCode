package main.practices.algorithmCourse.dynamicprograming;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 *               Find the length of the longest substring T of a given
 *               string (consists of lowercase letters only) such that
 *               every character in T appears no less than k times.
 *
 *               Example 1:
 *
 *               Input:
 *               s = "aaabb", k = 3
 *
 *               Output:
 *               3
 *
 *               The longest substring is "aaa", as 'a' is repeated 3
 *               times.
 *               Example 2:
 *
 *               Input:
 *               s = "ababbc", k = 2
 *
 *               Output:
 *               5
 *
 *               The longest substring is "ababb", as 'a' is repeated 2
 *               times and 'b' is repeated 3 times.
 * 
 *               思路：一开始想的是动态规划，那就是O(26*n*n)的复杂度了，超时了
 *               之后看题解才想到，分支法，按数量不够的字母分，这题完全就是思路问题了
 *               注意做好各种边界条件的检查
 * 
 * @Author: shenpeng
 * @Date: 2020-02-26
 */
public class LongestSubstring {

    //    public int longestSubstring(String s, int k) {
    //        int l = s.length();
    //        int dp[][][] = new int[l][l][26];
    //
    //        int[] chars = new int[l];
    //
    //        for (int i = 0; i < l; i++) {
    //            chars[i] = s.charAt(i) - 'a';
    //        }
    //
    //        for (int i = 0; i < l; i++) {
    //            dp[i][i][chars[i]] = 1;
    //        }
    //
    //        int result = 0;
    //        for (int i = 0; i < l; i++) {
    //            for (int j = i + 1; j < l; j++) {
    //                dp[i][j] = dp[i][j - 1];
    //                dp[i][j][chars[j]]++;
    //                if (check(dp[i][j], k)) {
    //                    if (j - i > result) {
    //                        result = j - i;
    //                    }
    //                }
    //            }
    //        }
    //        return result;
    //    }
    //
    //    private boolean check(int[] charNums, int k) {
    //        for (int i = 0; i < charNums.length; i++) {
    //            if (charNums[i] > 0 && charNums[i] < k) {
    //                return false;
    //            }
    //        }
    //        return true;
    //    }

    public int longestSubstring(String s, int k) {
        return count(s, k, 0, s.length() - 1);
    }

    public int count(String s, int k, int start, int end) {
        if (start > end) {
            return 0;
        }
        int[] cNums = new int[26];
        for (int i = start; i <= end; i++) {
            cNums[s.charAt(i) - 'a']++;
        }
        int result = 0;
        int temp = 0;
        List<Integer> invalidPos = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            if (cNums[s.charAt(i) - 'a'] < k) {
                invalidPos.add(i);
            }
        }
        if (invalidPos.size() == 0) {
            return end - start + 1;
        }
        int lastPpos = 0;
        for (int i = 0; i < invalidPos.size(); i++) {
            temp = count(s, k, lastPpos, invalidPos.get(i) - 1);
            lastPpos = invalidPos.get(i) + 1;
            if (temp > result) {
                result = temp;
            }
        }
        temp = count(s, k, invalidPos.get(invalidPos.size() - 1) + 1, end);
        if (temp > result) {
            result = temp;
        }
        return result;
    }
}
