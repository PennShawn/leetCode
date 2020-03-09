package main.practices.algorithmCourse.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 *               Given a non-empty string s and a dictionary wordDict
 *               containing a list of non-empty words, add spaces in s to
 *               construct a sentence where each word is a valid dictionary
 *               word. Return all such possible sentences.
 *
 *               Note:
 *
 *               The same word in the dictionary may be reused multiple
 *               times in the segmentation.
 *               You may assume the dictionary does not contain duplicate
 *               words.
 *               Example 1:
 *
 *               Input:
 *               s = "catsanddog"
 *               wordDict = ["cat", "cats", "and", "sand", "dog"]
 *               Output:
 *               [
 *               "cats and dog",
 *               "cat sand dog"
 *               ]
 *               Example 2:
 *
 *               Input:
 *               s = "pineapplepenapple"
 *               wordDict = ["apple", "pen", "applepen", "pine",
 *               "pineapple"]
 *               Output:
 *               [
 *               "pine apple pen apple",
 *               "pineapple pen apple",
 *               "pine applepen apple"
 *               ]
 *               Explanation: Note that you are allowed to reuse a
 *               dictionary word.
 *               Example 3:
 *
 *               Input:
 *               s = "catsandog"
 *               wordDict = ["cats", "dog", "sand", "and", "cat"]
 *               Output:
 *               []
 * 
 * @Author: shenpeng
 * @Date: 2020-02-23
 */
public class DictionaryString2 {

    class TreeNode {

        boolean end;

        Map<Character, TreeNode> next = new HashMap<>();

    }

    TreeNode root = new TreeNode();

    Map<Integer, List<String>> posResults = new HashMap<>();

    //  int[] posState;

    int l;

    public List<String> wordBreak(String s, List<String> wordDict) {
        l = s.length();
        //        posState = new int[l];
        //        posState[l - 1] = 1;
        //构建字典树
        for (String word : wordDict) {
            TreeNode treeNode = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (!treeNode.next.containsKey(c)) {
                    treeNode.next.put(c, new TreeNode());
                }
                treeNode = treeNode.next.get(c);
            }
            treeNode.end = true;
        }
        List<String> result = helper(s, 0);
        //        List<String> result = new ArrayList<>();
        //        for (StringBuilder stringBuilder : resultSb) {
        //            result.add(stringBuilder.toString());
        //        }
        return result;
    }

    public List<String> helper(String s, int start) {
        if (posResults.containsKey(start)) {
            return posResults.get(start);
        }
        TreeNode treeNode = root;
        List<String> result = new ArrayList<>();

        for (int i = start; i < l; i++) {
            if (treeNode.next.containsKey(s.charAt(i))) {
                treeNode = treeNode.next.get(s.charAt(i));
                if (treeNode.end) {
                    if (i == l - 1) {
                        result.add(s.substring(start, l));
                    } else {
                        List<String> nextResult = helper(s, i + 1);
                        if (nextResult.size() > 0) {
                            for (String s1 : nextResult) {
                                result.add(s.substring(start, i + 1) + " " + s1);
                            }
                        }
                    }
                }

            } else {
                break;
            }
        }
        posResults.put(start, result);
        return result;
    }

    public static void main(String[] args) {
        List<String> dict = new ArrayList<>();
        dict.add("ca");
        dict.add("bc");
        String s = "cbca";
        DictionaryString2 dictionaryString2 = new DictionaryString2();
        System.out.println(dictionaryString2.wordBreak(s, dict).toString());
    }

}
