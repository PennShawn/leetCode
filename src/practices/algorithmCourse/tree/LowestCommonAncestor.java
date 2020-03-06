package practices.algorithmCourse.tree;

import java.util.LinkedList;

/**
 * @Description:
 *               Given a binary tree, find the lowest common ancestor (LCA)
 *               of two given nodes in the tree.
 *
 *               According to the definition of LCA on Wikipedia: “The
 *               lowest common ancestor is defined between two nodes p and
 *               q as the lowest node in T that has both p and q as
 *               descendants (where we allow a node to be a descendant of
 *               itself).”
 *
 *               Given the following binary tree: root =
 *               [3,5,1,6,2,0,8,null,null,7,4]
 *
 *
 *
 *
 *               Example 1:
 *
 *               Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 *               Output: 3
 *               Explanation: The LCA of nodes 5 and 1 is 3.
 *               Example 2:
 *
 *               Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 *               Output: 5
 *               Explanation: The LCA of nodes 5 and 4 is 5, since a node
 *               can be a descendant of itself according to the LCA
 *               definition.
 *
 *
 *               Note:
 *
 *               All of the nodes' values will be unique.
 *               p and q are different and both values will exist in the
 *               binary tree.
 * @Author: shenpeng
 * @Date: 2020-03-06
 */
public class LowestCommonAncestor {

    // Definition for a binary tree node.
    class TreeNode {

        int val;

        TreeNode left;

        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    LinkedList<TreeNode> path1 = new LinkedList<>();

    LinkedList<TreeNode> path2 = new LinkedList<>();

    LinkedList<TreeNode> curpath = new LinkedList<>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        find(root, p, q);
        TreeNode result = root;
        while (!path1.isEmpty()) {
            result = path1.removeLast();
            if (path2.contains(result)) {
                break;
            }
        }
        return result;
    }

    public void find(TreeNode node, TreeNode p, TreeNode q) {
        if (!path2.isEmpty() && !path1.isEmpty()) {
            return;
        }
        curpath.add(node);
        if (node == p || node == q) {
            if (path1.isEmpty()) {
                path1 = new LinkedList<>(curpath);
            } else {
                path2 = new LinkedList<>(curpath);
                return;
            }
        }
        if (node.left != null) {
            find(node.left, p, q);
        }
        if (node.right != null) {
            find(node.right, p, q);
        }
        curpath.removeLast();
    }
}
