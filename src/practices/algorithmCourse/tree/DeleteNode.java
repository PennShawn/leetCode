package practices.algorithmCourse.tree;

/**
 * @Description:
 *               Given a root node reference of a BST and a key, delete the
 *               node with the given key in the BST. Return the root node
 *               reference (possibly updated) of the BST.
 *
 *               Basically, the deletion can be divided into two stages:
 *
 *               Search for a node to remove.
 *               If the node is found, delete the node.
 *               Note: Time complexity should be O(height of tree).
 *
 *               Example:
 *
 *               root = [5,3,6,2,4,null,7]
 *               key = 3
 *
 *               5
 *               / \
 *               3 6
 *               / \ \
 *               2 4 7
 *
 *               Given key to delete is 3. So we find the node with value 3
 *               and delete it.
 *
 *               One valid answer is [5,4,6,2,null,null,7], shown in the
 *               following BST.
 *
 *               5
 *               / \
 *               4 6
 *               / \
 *               2 7
 *
 *               Another valid answer is [5,2,6,null,4,null,7].
 *
 *               5
 *               / \
 *               2 6
 *               \ \
 *               4 7
 * 
 * 
 * 
 * 
 * @Author: shenpeng
 * @Date: 2020-03-06
 */
public class DeleteNode {

    // Definition for a binary tree node.
    class TreeNode {

        int val;

        TreeNode left;

        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        } else if (root.val == key) {
            if (root.left != null) {
                TreeNode leftNode = root.left;
                TreeNode rightNode = root.right;
                root = leftNode;
                while (leftNode.right != null) {
                    leftNode = leftNode.right;
                }
                leftNode.right = rightNode;

            } else {
                root = root.right;
            }
        } else {

            delNode(root, key);
        }
        return root;
    }

    public void delNode(TreeNode node, int key) {
        if (node.val > key) {
            if (node.left != null && node.left.val == key) {
                if (node.left.left != null) {
                    TreeNode rightNode = node.left.right;
                    TreeNode leftNode = node.left.left;
                    node.left = leftNode;
                    while (leftNode.right != null) {
                        leftNode = leftNode.right;
                    }
                    leftNode.right = rightNode;
                } else {
                    node.left = node.left.right;
                }
            } else {
                deleteNode(node.left, key);
            }
        } else if (node.val < key) {
            if (node.right != null && node.right.val == key) {
                if (node.right.right != null) {
                    TreeNode rightNode = node.right.right;
                    TreeNode leftNode = node.right.left;
                    node.right = rightNode;
                    while (rightNode.left != null) {
                        rightNode = rightNode.left;
                    }
                    rightNode.left = leftNode;
                } else {
                    node.right = node.right.left;
                }
            } else {
                deleteNode(node.right, key);
            }
        }
    }
}
