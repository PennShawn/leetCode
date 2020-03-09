package main.practices.algorithmCourse.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Description:
 * @Author: shenpeng
 * @Date: 2020-03-06
 */
public class PreorderTraversal {

    // Definition for a binary tree node.
    class TreeNode {

        int val;

        TreeNode left;

        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> nodeList = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode treeNode = root;

        while (treeNode != null || !stack.isEmpty()) {
            while (treeNode != null) {
                stack.push(treeNode);
                nodeList.add(treeNode.val);
                treeNode = treeNode.left;
            }
            treeNode = stack.pop().right;
        }
        return nodeList;
    }
}
