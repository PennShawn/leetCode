package main.practices.random;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description:
 *               A complete binary tree is a binary tree in which every
 *               level, except possibly the last, is completely filled, and
 *               all nodes are as far left as possible.
 *
 *               Write a data structure CBTInserter that is initialized
 *               with a complete binary tree and supports the following
 *               operations:
 *
 *               CBTInserter(TreeNode root) initializes the data structure
 *               on a given tree with head node root;
 *               CBTInserter.insert(int v) will insert a TreeNode into the
 *               tree with value node.val = v so that the tree remains
 *               complete, and returns the value of the parent of the
 *               inserted TreeNode;
 *               CBTInserter.get_root() will return the head node of the
 *               tree.
 *                
 *
 *               Example 1:
 *
 *               Input: inputs = ["CBTInserter","insert","get_root"],
 *               inputs = [[[1]],[2],[]]
 *               Output: [null,1,[1,2]]
 *               Example 2:
 *
 *               Input: inputs =
 *               ["CBTInserter","insert","insert","get_root"], inputs =
 *               [[[1,2,3,4,5,6]],[7],[8],[]]
 *               Output: [null,3,4,[1,2,3,4,5,6,7,8]]
 *                
 *
 *               Note:
 *
 *               The initial given tree is complete and contains between 1
 *               and 1000 nodes.
 *               CBTInserter.insert is called at most 10000 times per test
 *               case.
 *               Every value of a given or inserted node is between 0 and
 *               5000.
 *
 *               来源：力扣（LeetCode）
 *               链接：https://leetcode-cn.com/problems/complete-binary-tree-inserter
 *               著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: shenpeng
 * @Date: 2020-05-19
 */

//Definition for a binary tree node.

public class CBTInserter {

    private TreeNode root;

    public CBTInserter(TreeNode root) {
        this.root = root;
    }

    public int insert(int v) {
        TreeNode newNode = new TreeNode(v);
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        TreeNode treeNode = null;
        while (!nodeQueue.isEmpty()) {
            treeNode = nodeQueue.poll();
            if (treeNode.left == null) {
                treeNode.left = newNode;
                break;
            } else if (treeNode.right == null) {
                treeNode.right = newNode;
                break;
            } else {
                nodeQueue.offer(treeNode.left);
                nodeQueue.offer(treeNode.right);
            }
        }
        return treeNode.val;
    }

    public TreeNode get_root() {
        return root;
    }

    class TreeNode {

        int val;

        TreeNode left;

        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(v);
 * TreeNode param_2 = obj.get_root();
 */
