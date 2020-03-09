package main.practices.algorithmCourse.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Description:
 * 
 *               Given a binary tree, return the postorder traversal of its
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
 *               Output: [3,2,1]
 *               Follow up: Recursive solution is trivial, could you do it
 *               iteratively?
 * 
 *               思路：
 *               迭代的方法后序遍历的难点是,遍历完一个结点的左子树后,不能把当前结点弹出,而是要继续遍历右子树.node =
 *               stack.peek().right;,取右子结点继续按照之前的方法遍历一遍.
 *               因此,对于一个结点,它能不能被弹出,有两个条件:
 *
 *               1. 没有左子结点或者左子结点被遍历过了
 *               没有左子结点很好判断,在循环里取node = node.left,node为空的时候就行了.
 *               关于左子结点被遍历过了这个条件,因为我们知道在stack中,结点的左子结点一定在这个结点的后面,也就是比它先pop,如果一个结点是stack中最后一个结点,说明它的左子结点肯定pop过了,所以这一点不用加额外的判断,到了这个结点,说明左子结点肯定判断过了.
 *
 *               2. 没有右子结点或者右子结点被遍历过了.
 *               当我们要判断完一个结点的条件1后,还得先判断node =
 *               stack.peek().right;为不为空.为空的话就可以直接pop并加入result了.
 *               如果不为空,可以将右子结点,也就是右子树重复一遍操作.但问题是,这里有可能会重复遍历右子树,所以,我们得用一个lastNode记录下上一次pop的结点.如果一个结点的右子结点就是上次pop的结点,那就说明右子树被遍历过了.为什么只要记一个lastNode呢?因为后序遍历是左-右-上,当一个结点被放进结果时,如果它右右子结点,那么上一个结点一定是它的右子结点.
 *
 *               所以,总的思路是,先循环将左子结点入栈,没有左子结点后,如果有右子结点,再对右子结点执行一遍操作.当没有左子结点和右子结点时,出栈,加入到result中,然后取stack.peek,也就是刚刚放入结果的结点的父结点,然后取父结点的右子结点,再执行一遍判断.为了防止右子结点出栈后,'stack.peek.right'又取到了遍历过的右结点,重复遍历右子树,所以加了个lastNode来判断有没有遍历过右子结点.如果已经遍历过右子结点了,那么将父结点出栈.重复之前的循环,直到根结点出栈,结束循环.
 *
 *               作者：pennshawn
 *               链接：https://leetcode-cn.com/problems/binary-tree-postorder-traversal/solution/die-dai-bian-li-by-pennshawn/
 *               来源：力扣（LeetCode）
 *               著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * @Author: shenpeng
 * @Date: 2020-03-06
 */
public class PostorderTraversal {

    // Definition for a binary tree node.
    class TreeNode {

        int val;

        TreeNode left;

        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        TreeNode lastNode = null;
        while (node != null || !stack.isEmpty()) {
            while (node != null && node != lastNode) {
                stack.add(node);
                node = node.left;
            }
            node = stack.peek().right;
            if (node == null || node == lastNode) {
                lastNode = stack.pop();
                result.add(lastNode.val);
                if (stack.isEmpty()) {
                    break;
                }
                node = stack.peek().right;
            }
        }
        return result;
    }

    //
    //
    //
    //
    //
    //    public List<Integer> postorderTraversal(TreeNode root) {
    //        List<Integer> result = new ArrayList<>();
    //        if (root == null) {
    //            return result;
    //        }
    //        Stack<TreeNode> stack = new Stack<>();
    //        TreeNode treeNode = root;
    //        TreeNode cur = null;
    //        stack.push(root);
    //        treeNode = treeNode.left;
    //        while (!stack.isEmpty()) {
    //            while (treeNode != null && treeNode != cur) {
    //                stack.push(treeNode);
    //                treeNode = treeNode.left;
    //            }
    //            treeNode = stack.peek().right;
    //            if (treeNode != null && treeNode != cur) {
    //                stack.push(treeNode);
    //                treeNode = stack.peek().left;
    //            } else {
    //                cur = stack.pop();
    //                result.add(cur.val);
    //                if (stack.isEmpty()) {
    //                    break;
    //                }
    //                treeNode = stack.peek().right;
    //            }
    //        }
    //        return result;
    //
    //    }

    //    public List<Integer> postorderTraversal(TreeNode root) {
    //        List<Integer> result = new ArrayList<>();
    //        addNode(root, result);
    //        return result;
    //    }
    //
    //    public void addNode(TreeNode node, List<Integer> result) {
    //        if (node == null) {
    //            return;
    //        }
    //        addNode(node.left, result);
    //        addNode(node.right, result);
    //        result.add(node.val);
    //    }

}
