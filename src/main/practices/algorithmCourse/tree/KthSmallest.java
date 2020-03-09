package main.practices.algorithmCourse.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * 
 *               Given a binary search tree, write a function kthSmallest
 *               to find the kth smallest element in it.
 *
 *               Note:
 *               You may assume k is always valid, 1 ≤ k ≤ BST's total
 *               elements.
 *
 *               Example 1:
 *
 *               Input: root = [3,1,4,null,2], k = 1
 *               3
 *               / \
 *               1 4
 *               \
 *               2
 *               Output: 1
 *               Example 2:
 *
 *               Input: root = [5,3,6,2,4,null,null,1], k = 3
 *               5
 *               / \
 *               3 6
 *               / \
 *               2 4
 *               /
 *               1
 *               Output: 3
 *               Follow up:
 *               What if the BST is modified (insert/delete operations)
 *               often and you need to find the kth smallest frequently?
 *               How would you optimize the kthSmallest routine?
 * 
 *               思路：可以用个栈，就不用递归了，转成迭代，速度更快，找到了直接返回
 * @Author: shenpeng
 * @Date: 2020-03-06
 */
public class KthSmallest {

    // Definition for a binary tree node.
    class TreeNode {

        int val;

        TreeNode left;

        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int result;

    public int kthSmallest(TreeNode root, int k) {
        List<TreeNode> nodeList = new ArrayList<>();
        addNodeToList(root, k, nodeList);
        return result;
    }

    private void addNodeToList(TreeNode node, int k, List<TreeNode> nodeList) {
        if (node.left != null) {
            addNodeToList(node.left, k, nodeList);
        }
        if (nodeList.size() >= k) {
            result = nodeList.get(k - 1).val;
            return;
        }
        nodeList.add(node);
        if (node.right != null) {
            addNodeToList(node.right, k, nodeList);
        }
        if (nodeList.size() >= k) {
            result = nodeList.get(k - 1).val;
            return;
        }
    }
}
