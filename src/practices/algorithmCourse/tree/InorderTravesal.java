package practices.algorithmCourse.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Description:
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
 * @Author: shenpeng
 * @Date: 2020-03-06
 */
public class InorderTravesal {

    // Definition for a binary tree node.
    class TreeNode {

        int val;

        TreeNode left;

        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            result.add(node.val);
            node = node.right;
        }
        return result;

    }
}
