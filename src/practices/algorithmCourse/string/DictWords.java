package practices.algorithmCourse.string;

import java.util.*;

/**
 * @Description:
 *               Given a 2D board and a list of words from the dictionary,
 *               find all words in the board.
 *
 *               Each word must be constructed from letters of sequentially
 *               adjacent cell, where "adjacent" cells are those
 *               horizontally or vertically neighboring. The same letter
 *               cell may not be used more than once in a word.
 *
 *
 *
 *               Example:
 *
 *               Input:
 *               board = [
 *               ['o','a','a','n'],
 *               ['e','t','a','e'],
 *               ['i','h','k','r'],
 *               ['i','f','l','v']
 *               ]
 *               words = ["oath","pea","eat","rain"]
 *
 *               Output: ["eat","oath"]
 * 
 *               Note:
 *
 *               All inputs are consist of lowercase letters a-z.
 *               The values of words are distinct.
 * 
 *               思路1：字典树，但是这个字典太大了，(m*n)^4的复杂度，运行超时
 *               思路2：暴力法，遍历单词，然后遍历每一个字符，这样的问题是
 *               判断"aaa"可以后，单词"aaaa"又得重新判断一遍，没有利用好之前的步骤
 *               思路3：用单词表生成前缀树，遍历前缀树找到所有结果。
 * 
 *               note:数组是真的牛逼，数组索引比map快多了
 * 
 * @Author: shenpeng
 * @Date: 2020-02-24
 */
public class DictWords {

    //    class Node {
    //
    //        Map<Character, Node> next;
    //
    //        public Node() {
    //            next = new HashMap<>();
    //        }
    //    }
    //
    //    Node root = new Node();
    //
    //    int l1, l2, max;
    //
    //    public List<String> findWords(char[][] board, String[] words) {
    //        //        Map<Character, Integer> charNum = new HashMap<>();
    //
    //        List<String> result = new ArrayList<>();
    //        Node node;
    //        if (board.length == 0 || board[0].length == 0) {
    //            return new ArrayList<>();
    //        }
    //        l1 = board.length;
    //        l2 = board[0].length;
    //        max = l1 > l2 ? l1 : l2;
    //        for (int i = 0; i < l1; i++) {
    //            for (int j = 0; j < l2; j++) {
    //                // charNum.put(board[i][j], charNum.getOrDefault(board[i][j], 0) + 1);
    //                if (!root.next.containsKey(board[i][j])) {
    //                    root.next.put(board[i][j], new Node());
    //                }
    //                node = root.next.get(board[i][j]);
    //                Set<Integer> visited = new HashSet<>();
    //                visited.add(max * i + j);
    //                addAdjacentChar(i, j, board, node, visited);
    //            }
    //        }
    //
    //        int l3 = words.length;
    //        for (int i = 0; i < l3; i++) {
    //            boolean flag = true;
    //            Node node1 = root;
    //            //            Map<Character, Integer> cNum = new HashMap<>();
    //            for (int j = 0; j < words[i].length(); j++) {
    //                char c = words[i].charAt(j);
    //                //cNum.put(c, cNum.getOrDefault(c, 0) + 1);
    //                node1 = node1.next.get(c);
    //                if (node1 == null) {
    //                    flag = false;
    //                    break;
    //                }
    //            }
    //            if (flag) {
    //                result.add(words[i]);
    //            }
    //        }
    //        return result;
    //    }
    //
    //    public void addAdjacentChar(int i, int j, char[][] board, Node node, Set<Integer> visited) {
    //        Node nextNode;
    //        int x, y, pos;
    //        x = i - 1;
    //        pos = x * max + j;
    //        if (x >= 0 && !visited.contains(pos)) {
    //            if (!node.next.containsKey(board[x][j])) {
    //                node.next.put(board[x][j], new Node());
    //            }
    //            nextNode = node.next.get(board[x][j]);
    //            Set<Integer> curVisited = new HashSet<>(visited);
    //            curVisited.add(pos);
    //            addAdjacentChar(x, j, board, nextNode, curVisited);
    //        }
    //
    //        x = i + 1;
    //        pos = x * max + j;
    //        if (x < l1 && !visited.contains(pos)) {
    //            if (!node.next.containsKey(board[x][j])) {
    //                node.next.put(board[x][j], new Node());
    //            }
    //            nextNode = node.next.get(board[x][j]);
    //            Set<Integer> curVisited = new HashSet<>(visited);
    //            curVisited.add(pos);
    //            addAdjacentChar(x, j, board, nextNode, curVisited);
    //        }
    //
    //        y = j - 1;
    //        pos = i * max + y;
    //        if (y >= 0 && !visited.contains(pos)) {
    //            if (!node.next.containsKey(board[i][y])) {
    //                node.next.put(board[i][y], new Node());
    //            }
    //            nextNode = node.next.get(board[i][y]);
    //
    //            Set<Integer> curVisited = new HashSet<>(visited);
    //            curVisited.add(pos);
    //            addAdjacentChar(i, y, board, nextNode, curVisited);
    //        }
    //
    //        y = j + 1;
    //        pos = i * max + y;
    //        if (y < l2 && !visited.contains(pos)) {
    //            if (!node.next.containsKey(board[i][y])) {
    //                node.next.put(board[i][y], new Node());
    //            }
    //            nextNode = node.next.get(board[i][y]);
    //            Set<Integer> curVisited = new HashSet<>(visited);
    //            curVisited.add(pos);
    //            addAdjacentChar(i, y, board, nextNode, curVisited);
    //        }
    //
    //    }
    //
    //    public static void main(String[] args) {
    //        char[][] board = new char[][] { { 'o', 'a', 'a', 'n' }, { 'o', 'a', 'a', 'n' },
    //                { 'o', 'a', 'a', 'n' }, { 'o', 'a', 'a', 'n' } };
    //        String[] words = new String[] { "oaan", "oan" };
    //        DictWords dictWords = new DictWords();
    //        System.out.println(dictWords.findWords(board, words).toString());
    //        for (Map.Entry<Character, Node> entry : dictWords.root.next.entrySet()) {
    //            System.out.println(entry.getKey() + "   " + entry.getValue().next.keySet().toString());
    //        }
    //        System.out.println(dictWords.root.next.values());
    //    }

    //    class Pos {
    //
    //        int x, y;
    //
    //        public Pos(int x, int y) {
    //            this.x = x;
    //            this.y = y;
    //        }
    //
    //        public int getX() {
    //            return x;
    //        }
    //
    //        public void setX(int x) {
    //            this.x = x;
    //        }
    //
    //        public int getY() {
    //            return y;
    //        }
    //
    //        public void setY(int y) {
    //            this.y = y;
    //        }
    //    }
    //
    //    int l1, l2, max;
    //
    //    public List<String> findWords(char[][] board, String[] words) {
    //
    //        l1 = board.length;
    //        if (l1 == 0) {
    //            return new ArrayList<>();
    //        }
    //        l2 = board[0].length;
    //        if (l2 == 0) {
    //            return new ArrayList<>();
    //        }
    //        max = l1 > l2 ? l1 : l2;
    //
    //        Map<Character, List<Pos>> charPos = new HashMap<>();
    //        for (int i = 0; i < l1; i++) {
    //            for (int j = 0; j < l2; j++) {
    //                if (charPos.containsKey(board[i][j])) {
    //                    charPos.get(board[i][j]).add(new Pos(i, j));
    //                } else {
    //                    List<Pos> poses = new ArrayList<>();
    //                    poses.add(new Pos(i, j));
    //                    charPos.put(board[i][j], poses);
    //                }
    //            }
    //        }
    //        List<String> result = new ArrayList<>();
    //        for (String word : words) {
    //            char c = word.charAt(0);
    //            List<Pos> poses = charPos.get(c);
    //            if (null == poses) {
    //                continue;
    //            }
    //            for (Pos pos : poses) {
    //                Set<Integer> visited = new HashSet<>();
    //                visited.add(pos.getX() * max + pos.getY());
    //                if (findChar(board, word, 1, pos.getX(), pos.getY(), visited)) {
    //                    result.add(word);
    //                    break;
    //                }
    //            }
    //        }
    //        return result;
    //    }
    //
    //    public boolean findChar(char[][] board, String word, int start, int x, int y,
    //            Set<Integer> visited) {
    //        if (start == word.length()) {
    //            return true;
    //        }
    //        char c = word.charAt(start);
    //
    //        int x1 = x - 1;
    //        int pos = x1 * max + y;
    //        if (x1 >= 0 && board[x1][y] == c && !visited.contains(pos)) {
    //            Set<Integer> curVisited = new HashSet<>(visited);
    //            curVisited.add(pos);
    //            if (findChar(board, word, start + 1, x1, y, curVisited)) {
    //                return true;
    //            }
    //        }
    //
    //        x1 = x + 1;
    //        pos = x1 * max + y;
    //        if (x1 < l1 && board[x1][y] == c && !visited.contains(pos)) {
    //            Set<Integer> curVisited = new HashSet<>(visited);
    //            curVisited.add(pos);
    //            if (findChar(board, word, start + 1, x1, y, curVisited)) {
    //                return true;
    //            }
    //        }
    //
    //        int y1 = y - 1;
    //        pos = x * max + y1;
    //        if (y1 >= 0 && board[x][y1] == c && !visited.contains(pos)) {
    //            Set<Integer> curVisited = new HashSet<>(visited);
    //            curVisited.add(pos);
    //            if (findChar(board, word, start + 1, x, y1, curVisited)) {
    //                return true;
    //            }
    //        }
    //
    //        y1 = y + 1;
    //        pos = x * max + y1;
    //        if (y1 < l2 && board[x][y1] == c && !visited.contains(pos)) {
    //            Set<Integer> curVisited = new HashSet<>(visited);
    //            curVisited.add(pos);
    //            if (findChar(board, word, start + 1, x, y1, curVisited)) {
    //                return true;
    //            }
    //        }
    //        return false;
    //    }
    //
    public static void main(String[] args) {
        boolean[][] a = new boolean[1][2];
        System.out.println(a[0][1]);
        char[][] board = new char[][] { { 'a', 'b' } };
        String[] words = new String[] { "ba" };
        DictWords dictWords = new DictWords();
        System.out.println(dictWords.findWords(board, words));

    }

    class Node {

        //        Map<Character, Node> next;

        Node[] next = new Node[26];

        /**
         * 只有一个单词的结尾才有值
         */
        String value;

        boolean leaf;

        public Node() {

        }
    }

    Node root = new Node();

    int l1, l2;

    public List<String> findWords(char[][] board, String[] words) {
        //构建前缀树
        for (String word : words) {
            Node node = root;
            for (int i = 0; i < word.length(); i++) {
                if (node.next[word.charAt(i) - 'a'] == null) {
                    node.next[word.charAt(i) - 'a'] = new Node();
                }
                node = node.next[word.charAt(i) - 'a'];
            }
            node.value = word;
            node.leaf = true;
        }

        l1 = board.length;
        if (l1 == 0) {
            return new ArrayList<>();
        }
        l2 = board[0].length;
        if (l2 == 0) {
            return new ArrayList<>();
        }
        boolean[][] visited = new boolean[l1][l2];
        //        max = l1 > l2 ? l1 : l2;
        Set<String> results = new HashSet<>();
        for (int i = 0; i < l1; i++) {
            for (int j = 0; j < l2; j++) {
                searchTrie(board, i, j, root, results, visited);
            }
        }
        return new ArrayList<>(results);
    }

    public void searchTrie(char[][] board, int i, int j, Node node, Set<String> result,
            boolean[][] visited) {
        if (i < 0 || j < 0 || i >= l1 || j >= l2) {
            return;
        }
        if (visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        Node next = node.next[board[i][j] - 'a'];
        if (null == next) {
            visited[i][j] = false;
            return;
        }
        if (next.leaf) {
            result.add(next.value);
        }
        searchTrie(board, i - 1, j, next, result, visited);
        searchTrie(board, i + 1, j, next, result, visited);
        searchTrie(board, i, j - 1, next, result, visited);
        searchTrie(board, i, j + 1, next, result, visited);
        visited[i][j] = false;

    }
}

//    public List<String> findWords(char[][] board, String[] words) {
//        //构建字典树
//        wordTrie myTrie = new wordTrie();
//        trieNode root = myTrie.root;
//        for (String s : words) {
//            myTrie.insert(s);
//        }
//
//        //使用set防止重复
//        Set<String> result = new HashSet<>();
//        int m = board.length;
//        int n = board[0].length;
//        boolean[][] visited = new boolean[m][n];
//        //遍历整个二维数组
//        for (int i = 0; i < board.length; i++) {
//            for (int j = 0; j < board[0].length; j++) {
//                find(board, visited, i, j, m, n, result, root);
//            }
//        }
//        System.out.print(result);
//        return new LinkedList<String>(result);
//    }
//
//    private void find(char[][] board, boolean[][] visited, int i, int j, int m, int n,
//            Set<String> result, trieNode cur) {
//        //边界以及是否已经访问判断
//        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j]) {
//            return;
//        }
//        cur = cur.child[board[i][j] - 'a'];
//        visited[i][j] = true;
//        if (cur == null) {
//            //如果单词不匹配，回退
//            visited[i][j] = false;
//            return;
//        }
//        //找到单词加入
//        if (cur.isLeaf) {
//            result.add(cur.val);
//            //找到单词后不能回退，因为可能是“ad” “addd”这样的单词得继续回溯
//            //            visited[i][j]=false;
//            //            return;
//        }
//        find(board, visited, i + 1, j, m, n, result, cur);
//        find(board, visited, i, j + 1, m, n, result, cur);
//        find(board, visited, i, j - 1, m, n, result, cur);
//        find(board, visited, i - 1, j, m, n, result, cur);
//        //最后要回退，因为下一个起点可能会用到上一个起点的字符
//        visited[i][j] = false;
//    }
//
//}
//
////字典树
//class wordTrie {
//
//    public trieNode root = new trieNode();
//
//    public void insert(String s) {
//        trieNode cur = root;
//        for (char c : s.toCharArray()) {
//            if (cur.child[c - 'a'] == null) {
//                cur.child[c - 'a'] = new trieNode();
//                cur = cur.child[c - 'a'];
//            } else {
//                cur = cur.child[c - 'a'];
//            }
//        }
//        cur.isLeaf = true;
//        cur.val = s;
//    }
//}
//
////字典树结点
//class trieNode {
//
//    public String val;
//
//    public trieNode[] child = new trieNode[26];
//
//    public boolean isLeaf = false;
//
//    trieNode() {
//
//    }
//}
