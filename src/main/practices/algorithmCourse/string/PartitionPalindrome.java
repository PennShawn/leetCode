package main.practices.algorithmCourse.string;

import java.util.LinkedList;
import java.util.List;

/**
 * @Description:
 *               Given a string s, partition s such that every substring of
 *               the partition is a palindrome.
 *
 *               Return all possible palindrome partitioning of s.
 *
 *               Example:
 *
 *               Input: "aab"
 *               Output:
 *               [
 *               ["aa","b"],
 *               ["a","a","b"]
 *               ]
 * 
 *               思路：这题还是递归求解，但是isPalindrome（）这个方法可以优化下，用一个数组把所有的回文字符串用
 *               动态规划的方法存起来，这样对于重复的字符串就可以不用多次判断了
 * 
 * 
 * @Author: shenpeng
 * @Date: 2020-02-21
 */
public class PartitionPalindrome {

    public static void main(String[] args) {
        System.out.println("ab".charAt(3));
        //        System.out.println("ab".charAt(0));
    }

    public List<List<String>> partition(String s) {
        boolean[][] isPalindrome = new boolean[s.length()][s.length() + 1];
        for (int len = 1; len <= s.length(); len++) {
            for (int i = 0; i <= s.length() - len; i++) {
                int end = i + len;
                isPalindrome[i][end] = s.charAt(i) == s.charAt(end - 1)
                        && (len < 3 || isPalindrome[i + 1][end - 1]);
            }
        }

        //        List<List<String>> result = new LinkedList<>();
        //        if (s.length() == 1) {
        //            LinkedList<String> linkedList = new LinkedList<>();
        //            linkedList.add(s);
        //            result.add(linkedList);
        //        } else {
        //
        //            for (int i = 1; i < s.length(); i++) {
        //                String subStr = s.substring(0, i);
        //                if (isPalindrome(subStr)) {
        //                    List<List<String>> nextResult = partition(s.substring(i));
        //                    for (List<String> strings : nextResult) {
        //                        strings.add(0, subStr);
        //                        result.add(strings);
        //                    }
        //                }
        //            }
        //            if (isPalindrome(s)) {
        //                List<String> newList = new LinkedList<>();
        //                newList.add(s);
        //                result.add(newList);
        //            }
        //        }
        //        return result;
        return partition2(s, 0, isPalindrome);
    }

    public List<List<String>> partition2(String s, int start, boolean[][] isPalindrome) {
        List<List<String>> result = new LinkedList<>();
        if (start == s.length()) {
            LinkedList<String> linkedList = new LinkedList<>();
            result.add(linkedList);
        } else {
            int end = s.length() - start;
            for (int i = 1; i < end; i++) {
                int nextStart = start + i;

                if (isPalindrome[start][nextStart]) {
                    List<List<String>> nextResult = partition2(s, nextStart, isPalindrome);
                    String subStr = s.substring(start, nextStart);
                    for (List<String> strings : nextResult) {
                        strings.add(0, subStr);
                        result.add(strings);
                    }
                }
            }
            if (isPalindrome[start][s.length()]) {
                List<String> newList = new LinkedList<>();
                newList.add(s.substring(start));
                result.add(newList);
            }
        }
        return result;
    }
    //    public boolean isPalindrome(String s) {
    //
    //        int halfL = s.length() / 2;
    //        int end = s.length() - 1;
    //        for (int i = 0; i < halfL; i++) {
    //            if (s.charAt(i) != s.charAt(end - i)) {
    //                return false;
    //            }
    //        }
    //        return true;
    //    }

}
