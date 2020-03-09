package main.practices.queuestack.stack;

import java.util.LinkedList;
import java.util.List;

/**
 * @Description:
 * 
 *               Given a binary tree, return the inorder traversal of its
 *               nodes' values.
 *
 *               Example:
 *
 *               Input: [1,null,2,3]
 *               1
 *               \
 *               2
 *               /
 *               3
 *
 *               Output: [1,3,2]
 *               Follow up: Recursive solution is trivial, could you do it
 *               iteratively?
 * 
 * @Author: shenpeng
 * @Date: 2020-01-31
 */

public class InorderTracersal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        addToList(result, root);
        return result;
    }

    private void addToList(List<Integer> result, TreeNode treeNode) {
        if (null != treeNode.left) {
            addToList(result, treeNode.left);
        }
        result.add(treeNode.val);
        if (null != treeNode.right) {
            addToList(result, treeNode.right);
        }
    }
}

class TreeNode {

    int val;

    TreeNode left;

    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
