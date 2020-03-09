package main.practices.algorithmCourse.dynamicprograming;

/**
 * @Description:
 * 
 *               Given a non-empty binary tree, find the maximum path sum.
 *
 *               For this problem, a path is defined as any sequence of
 *               nodes from some starting node to any node in the tree
 *               along the parent-child connections. The path must contain
 *               at least one node and does not need to go through the
 *               root.
 *
 *               Example 1:
 *
 *               Input: [1,2,3]
 *
 *               1
 *               / \
 *               2 3
 *
 *               Output: 6
 *               Example 2:
 *
 *               Input: [-10,9,20,null,null,15,7]
 *
 *               -10
 *               / \
 *               9 20
 *               / \
 *               15 7
 *
 *               Output: 42
 * @Author: shenpeng
 * @Date: 2020-03-07
 */
public class MaxPathSum {

    // Definition for a binary tree node.
    class TreeNode {

        int val;

        TreeNode left;

        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int maxPathSum(TreeNode root) {
        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        findMax(root, max);
        return max[0];
    }

    public int findMax(TreeNode node, int[] max) {
        if (node == null) {
            return 0;
        }
        int l = Math.max(findMax(node.left, max), 0);
        int r = Math.max(findMax(node.right, max), 0);
        int result = l + r + node.val;
        max[0] = Math.max(max[0], result);
        return Math.max(l + node.val, r + node.val);
    }
}
