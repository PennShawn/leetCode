package main.practices.algorithmCourse.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 *               Implement a trie with insert, search, and startsWith
 *               methods.
 *
 *               Example:
 *
 *               Trie trie = new Trie();
 *
 *               trie.insert("apple");
 *               trie.search("apple"); // returns true
 *               trie.search("app"); // returns false
 *               trie.startsWith("app"); // returns true
 *               trie.insert("app");
 *               trie.search("app"); // returns true
 *               Note:
 *
 *               You may assume that all inputs are consist of lowercase
 *               letters a-z.
 *               All inputs are guaranteed to be non-empty strings.
 * @Author: shenpeng
 * @Date: 2020-02-23
 */
public class Trie {

    class Node {

        boolean end;

        Map<Character, Node> next = new HashMap<>();

        public Node() {
        }
    }

    Node root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new Node();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!node.next.containsKey(c)) {
                node.next.put(c, new Node());
            }
            node = node.next.get(c);
        }
        node.end = true;

    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            node = node.next.get(c);
            if (node == null) {
                return false;
            }
        }
        return node.end;
    }

    /**
     * Returns if there is any word in the trie that starts with the given
     * prefix.
     */
    public boolean startsWith(String prefix) {
        Node node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            node = node.next.get(c);
            if (node == null) {
                return false;
            }
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
