package main.practices.algorithmCourse.graph;

import java.util.*;

/**
 * @Description:
 *               Given two words (beginWord and endWord), and a
 *               dictionary's word list, find the length of shortest
 *               transformation sequence from beginWord to endWord, such
 *               that:
 *
 *               Only one letter can be changed at a time.
 *               Each transformed word must exist in the word list. Note
 *               that beginWord is not a transformed word.
 *               Note:
 *
 *               Return 0 if there is no such transformation sequence.
 *               All words have the same length.
 *               All words contain only lowercase alphabetic characters.
 *               You may assume no duplicates in the word list.
 *               You may assume beginWord and endWord are non-empty and are
 *               not the same.
 *               Example 1:
 *
 *               Input:
 *               beginWord = "hit",
 *               endWord = "cog",
 *               wordList = ["hot","dot","dog","lot","log","cog"]
 *
 *               Output: 5
 *
 *               Explanation: As one shortest transformation is "hit" ->
 *               "hot" -> "dot" -> "dog" -> "cog",
 *               return its length 5.
 *               Example 2:
 *
 *               Input:
 *               beginWord = "hit"
 *               endWord = "cog"
 *               wordList = ["hot","dot","dog","lot","log"]
 *
 *               Output: 0
 *
 *               Explanation: The endWord "cog" is not in wordList,
 *               therefore no possible transformation.
 * 
 *               思路：关键是visited优化，用数组不用set；
 *               双向遍历，每次遍历数量少的那一头；
 *               判断是否相邻的优化，我之前的方法每次都吧当前字符串和nodeMap里所有的字符串判断一次，数量大的时候效率太低了
 * @Author: shenpeng
 * @Date: 2020-03-11
 */
public class LadderLength {

    //    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    //        int end = wordList.indexOf(endWord);
    //        if (end == -1) {
    //            return 0;
    //        }
    //        wordList.add(beginWord);
    //
    //        // 从两端BFS遍历要用的队列
    //        Queue<String> queue1 = new LinkedList<>();
    //        Queue<String> queue2 = new LinkedList<>();
    //        // 两端已经遍历过的节点
    //        Set<String> visited1 = new HashSet<>();
    //        Set<String> visited2 = new HashSet<>();
    //        queue1.offer(beginWord);
    //        queue2.offer(endWord);
    //        visited1.add(beginWord);
    //        visited2.add(endWord);
    //
    //        int count = 0;
    //        Set<String> allWordSet = new HashSet<>(wordList);
    //
    //        while (!queue1.isEmpty() && !queue2.isEmpty()) {
    //            count++;
    //            if (queue1.size() > queue2.size()) {
    //                Queue<String> tmp = queue1;
    //                queue1 = queue2;
    //                queue2 = tmp;
    //                Set<String> t = visited1;
    //                visited1 = visited2;
    //                visited2 = t;
    //            }
    //            int size1 = queue1.size();
    //            while (size1-- > 0) {
    //                String s = queue1.poll();
    //                char[] chars = s.toCharArray();
    //                for (int j = 0; j < s.length(); ++j) {
    //                    // 保存第j位的原始字符
    //                    char c0 = chars[j];
    //                    for (char c = 'a'; c <= 'z'; ++c) {
    //                        chars[j] = c;
    //                        String newString = new String(chars);
    //                        // 已经访问过了，跳过
    //                        if (visited1.contains(newString)) {
    //                            continue;
    //                        }
    //                        // 两端遍历相遇，结束遍历，返回count
    //                        if (visited2.contains(newString)) {
    //                            return count + 1;
    //                        }
    //                        // 如果单词在列表中存在，将其添加到队列，并标记为已访问
    //                        if (allWordSet.contains(newString)) {
    //                            queue1.offer(newString);
    //                            visited1.add(newString);
    //                        }
    //                    }
    //                    // 恢复第j位的原始字符
    //                    chars[j] = c0;
    //                }
    //            }
    //        }
    //        return 0;
    //    }
    //}

    class Node {

        Set<Node> next = new HashSet<>();

        String val;

        public Node(String val) {
            this.val = val;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, Node> nodeMap = new HashMap<>();
        boolean contains = false;
        int n = beginWord.length();
        for (String s : wordList) {
            if (s.equals(endWord)) {
                contains = true;
            }
            Node curNode = new Node(s);
            char[] chars = s.toCharArray();
            for (int i = 0; i < n; i++) {
                for (int j = 'a'; j <= 'z'; j++) {
                    chars[i] = (char) j;
                    String s1 = new String(chars);
                    if (nodeMap.containsKey(s1)) {
                        Node nextNode = nodeMap.get(s1);
                        nextNode.next.add(curNode);
                        curNode.next.add(nextNode);
                    }
                    chars[i] = s.charAt(i);
                }
            }
            nodeMap.put(s, curNode);
        }
        if (!contains) {
            return 0;
        }
        Node beginNode = new Node(beginWord);
        char[] chars = beginWord.toCharArray();
        for (int i = 0; i < n; i++) {
            for (int j = 'a'; j <= 'z'; j++) {
                chars[i] = (char) j;
                String s1 = new String(chars);
                if (nodeMap.containsKey(s1)) {
                    Node nextNode = nodeMap.get(s1);
                    beginNode.next.add(nextNode);
                }
                chars[i] = beginWord.charAt(i);
            }
        }

        //        for (String s1 : nodeMap.keySet()) {
        //            if (isNext(beginWord, s1)) {
        //                Node nextNode = nodeMap.get(s1);
        //                beginNode.next.add(nextNode);
        //            }
        //        }
        Set<String> visited = new HashSet<>();
        nodeMap.put(beginWord, beginNode);
        visited.add(beginWord);
        int result = 1;
        Set<String> curStrs = new HashSet<>();
        curStrs.add(beginWord);
        while (visited.size() < nodeMap.size()) {
            if (curStrs.size() == 0) {
                break;
            }
            result++;
            Set<String> nextStrs = new HashSet<>();
            for (String curStr : curStrs) {
                Node node = nodeMap.get(curStr);
                for (Node node1 : node.next) {
                    if (!visited.contains(node1.val)) {
                        visited.add(node1.val);
                        nextStrs.add(node1.val);
                    }
                }
            }
            if (nextStrs.contains(endWord)) {
                return result;
            } else {
                curStrs = nextStrs;
            }
        }
        return 0;

        //        int[] curResult = new int[1];
        //        curResult[0] = Integer.MAX_VALUE;
        //        length(nodeMap, beginWord, endWord, visited, curResult, 0);
        //        int result = curResult[0];
        //        if (result == Integer.MAX_VALUE) {
        //            return 0;
        //        } else {
        //            return result;
        //        }
    }

    public void length(Map<String, Node> nodeMap, String curWord, String endWord,
            Set<String> visited, int[] curResult, int curStep) {
        if (curStep >= curResult[0]) {
            return;
        }
        curStep++;
        if (curWord.equals(endWord)) {
            if (curStep < curResult[0]) {
                curResult[0] = curStep;
            }
        } else {
            visited.add(curWord);
            for (Node node : nodeMap.get(curWord).next) {
                if (!visited.contains(node.val)) {
                    length(nodeMap, node.val, endWord, visited, curResult, curStep);
                }
            }
            visited.remove(curWord);
        }
    }

    private boolean isNext(String s1, String s2) {
        int diff = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diff++;
                if (diff >= 2) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LadderLength ladderLength = new LadderLength();
        List<String> list = new ArrayList<>();
        list.add("hot");
        list.add("dog");
        System.out.println(ladderLength.ladderLength("hot", "dog", list));
    }

}
