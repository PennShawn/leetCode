package main.practices.algorithmCourse.string;

/**
 * @Description:Given a string s, find the longest palindromic substring in
 *                    s. You may assume that the maximum length of s is
 *                    1000.
 *
 *                    Example 1:
 *
 *                    Input: "babad"
 *                    Output: "bab"
 *                    Note: "aba" is also a valid answer.
 *                    Example 2:
 *
 *                    Input: "cbbd"
 *                    Output: "bb"
 *
 *                    来源：力扣（LeetCode）
 *                    链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 *                    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: shenpeng
 * @Date: 2020-04-05
 */
public class LongestPalindStr {

    public String longestPalindrome(String s) {
        int l = s.length();
        boolean[][] dp = new boolean[l][l + 1];
        int x = 0;
        int y = 0;
        for (int i = 0; i < l; i++) {
            dp[i][i] = true;
            dp[i][i + 1] = true;
            x = i;
            y = i + 1;
        }
        for (int i = 2; i <= l; i++) {
            int max = l - i;
            for (int j = 0; j <= max; j++) {
                int end = j + i;
                if (dp[j + 1][end - 1]) {
                    if (s.charAt(j) == s.charAt(end - 1)) {
                        dp[j][end] = true;
                        x = j;
                        y = end;
                    }
                }
            }
        }
        return s.substring(x, y);
    }
}
