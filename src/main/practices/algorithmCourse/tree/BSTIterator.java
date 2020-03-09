package main.practices.algorithmCourse.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 *               Implement an iterator over a binary search tree (BST).
 *               Your iterator will be initialized with the root node of a
 *               BST.
 *
 *               Calling next() will return the next smallest number in the
 *               BST.
 *
 *
 *
 *               Example:
 *
 *
 *
 *               BSTIterator iterator = new BSTIterator(root);
 *               iterator.next(); // return 3
 *               iterator.next(); // return 7
 *               iterator.hasNext(); // return true
 *               iterator.next(); // return 9
 *               iterator.hasNext(); // return true
 *               iterator.next(); // return 15
 *               iterator.hasNext(); // return true
 *               iterator.next(); // return 20
 *               iterator.hasNext(); // return false
 * @Author: shenpeng
 * @Date: 2020-03-06
 */
public class BSTIterator {

    // Definition for a binary tree node.
    class TreeNode {

        int val;

        TreeNode left;

        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    List<TreeNode> nodeList;

    int curIndex;

    public BSTIterator(TreeNode root) {
        nodeList = new ArrayList<>();
        curIndex = 0;
        if (root != null) {
            addNode(root);
        }
    }

    private void addNode(TreeNode node) {
        if (node.left != null) {
            addNode(node.left);
        }
        nodeList.add(node);
        if (node.right != null) {
            addNode(node.right);
        }
    }

    /** @return the next smallest number */
    public int next() {
        return nodeList.get(curIndex++).val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return curIndex < nodeList.size();
    }

}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
