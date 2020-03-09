package main.practices.algorithmCourse.tree;

import java.util.ArrayDeque;

/**
 * @Description:
 *               Serialization is the process of converting a data
 *               structure or object into a sequence of bits so that it can
 *               be stored in a file or memory buffer, or transmitted
 *               across a network connection link to be reconstructed later
 *               in the same or another computer environment.
 *
 *               Design an algorithm to serialize and deserialize a binary
 *               tree. There is no restriction on how your
 *               serialization/deserialization algorithm should work. You
 *               just need to ensure that a binary tree can be serialized
 *               to a string and this string can be deserialized to the
 *               original tree structure.
 *
 *               Example:
 *
 *               You may serialize the following tree:
 *
 *               1
 *               / \
 *               2 3
 *               / \
 *               4 5
 *
 *               as "[1,2,3,null,null,4,5]"
 *               Clarification: The above format is the same as how
 *               LeetCode serializes a binary tree. You do not necessarily
 *               need to follow this format, so please be creative and come
 *               up with different approaches yourself.
 *
 *               Note: Do not use class member/global/static variables to
 *               store states. Your serialize and deserialize algorithms
 *               should be stateless.
 * 
 *               思路：层序遍历
 * @Author: shenpeng
 * @Date: 2020-03-07
 */
public class Codec {

    // Definition for a binary tree node.
    static class TreeNode {

        int val;

        TreeNode left;

        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        TreeNode node = root;
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        if (node != null) {
            sb.append(node.val).append("_");
            queue.push(node);
        }
        while (!queue.isEmpty()) {
            node = queue.pop();
            if (node.left != null) {
                sb.append(node.left.val).append("_");
                queue.push(node.left);
            } else {
                sb.append("null_");
            }
            if (node.right != null) {
                sb.append(node.right.val).append("_");
                queue.push(node.right);
            } else {
                sb.append("null_");
            }
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        String[] datas = data.split("_");
        TreeNode root = new TreeNode(Integer.valueOf(datas[0]));
        queue.push(root);
        TreeNode node;
        for (int i = 1; i < datas.length; i += 2) {
            node = queue.pop();
            if (!"null".equals(datas[i])) {
                TreeNode left = new TreeNode(Integer.valueOf(datas[i]));
                node.left = left;
                queue.push(left);
            }
            if (!"null".equals(datas[i + 1])) {
                TreeNode right = new TreeNode(Integer.valueOf(datas[i + 1]));
                node.right = right;
                queue.push(right);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);

        Codec codec = new Codec();
        codec.deserialize(codec.serialize(null));
        String s = "1-23";
        String[] array = s.split("-");
        System.out.println(array.length);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
