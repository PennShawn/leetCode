package practices.algorithmCourse.string;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Description:
 *               Given a non-empty string s and a dictionary wordDict
 *               containing a list of non-empty words, determine if s can
 *               be segmented into a space-separated sequence of one or
 *               more dictionary words.
 *
 *               Note:
 *
 *               The same word in the dictionary may be reused multiple
 *               times in the segmentation.
 *               You may assume the dictionary does not contain duplicate
 *               words.
 *               Example 1:
 *
 *               Input: s = "leetcode", wordDict = ["leet", "code"]
 *               Output: true
 *               Explanation: Return true because "leetcode" can be
 *               segmented as "leet code".
 *               Example 2:
 *
 *               Input: s = "applepenapple", wordDict = ["apple", "pen"]
 *               Output: true
 *               Explanation: Return true because "applepenapple" can be
 *               segmented as "apple pen apple".
 *               Note that you are allowed to reuse a dictionary word.
 *               Example 3:
 *
 *               Input: s = "catsandog", wordDict = ["cats", "dog", "sand",
 *               "and", "cat"]
 *               Output: false
 * 
 * 
 *               思路：字符串可以由字典里的元素组成 = 子字符串1在字典中 and 子字符串2可以由字典里的元素组成
 *               所以是一个动态规划的问题，为了防止多次判断一个子字符串是否可以由字典里的元素组成，可以用一个状态数组存起来。
 * 
 * 
 *               更优的方法是构建一个字典树，这样就避免了很多substring的操作，时间复杂度更低。
 * 
 * 
 * @Author: shenpeng
 * @Date: 2020-02-23
 */
public class DictionaryString {

    Set<String> newDict;

    boolean[] visited;

    public boolean wordBreak(String s, List<String> wordDict) {
        newDict = new HashSet<>(wordDict);
        visited = new boolean[s.length() + 1];
        return wordBreak2(s, 0);
    }

    public boolean wordBreak2(String s, int start) {
        if (start == s.length()) {
            return true;
        } else if (visited[start]) {
            return false;
        } else {
            for (int i = s.length(); i >= start + 1; i--) {
                if (newDict.contains(s.substring(start, i))) {
                    if (wordBreak2(s, i)) {
                        return true;
                    }
                }
            }
            visited[start] = true;
            return false;

        }
    }

    //    public class TrieNode {
    //        boolean flag;
    //        HashMap<Character, TrieNode> next = new HashMap<Character, TrieNode>();
    //
    //        public TrieNode() {
    //            flag = false;
    //        }
    //    }
    //
    //    TrieNode root;
    //    //List<Integer>  memo = new LinkedList<Integer>();
    //    int[] memo;
    //
    //    public boolean helper(String s, int start, int end) {
    //        if(start == end) {
    //            return true;
    //        }
    //        if (start == end) {
    //            return true;
    //        }
    //        if (memo[start] != 0) {
    //            return memo[start] > 0;
    //        }
    //        TrieNode node = root;
    //        for (int i = start; i < end; ++i) {
    //            if (!node.next.containsKey(s.charAt(i))) {
    //                break;
    //            }
    //            node = node.next.get(s.charAt(i));
    //            if (node.flag && helper(s, i + 1, end)){
    //                memo[start] = 1;
    //                return true;
    //            }
    //        }
    //        memo[start] = -1;
    //        return false;
    //    }
    //
    //    public boolean wordBreak2(String s, List<String> wordDict) {
    //        memo = new int[s.length()];
    //        root = new TrieNode();
    //        TrieNode node = root;
    //        for(String word : wordDict){
    //            node = root;
    //            for(char ch : word.toCharArray()){
    //                if(!node.next.containsKey(ch)){
    //                    node.next.put(ch, new TrieNode());
    //                }
    //                node = node.next.get(ch);
    //            }
    //            node.flag = true;
    //        }
    //        return helper(s, 0, s.length());
    //    }

}
