package practices.algorithmCourse.tree;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

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
 * 
 *               思路:
 *               递归的方法很多题解都有,能用迭代的方法的时候我倾向于迭代.
 *               对于树中的结点p和q,肯定存在一条唯一的路径是从root到p的,也存在一条唯一的路径是从root到q的.我们可以采用深度优先遍历,把这两条路径找出来,然后反着遍历一条路路径上的结点,如果存在于另一条路径中,说明就是公共祖先.
 *
 *               作者：pennshawn
 *               链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/solution/die-dai-de-fang-fa-hui-su-by-pennshawn/
 *               来源：力扣（LeetCode）
 *               著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
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

    LinkedList<TreeNode> curpath = new LinkedList<>();

    TreeNode lastNode = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode node = root;
        while (node != null || curpath.size() > 0) {
            while (node != null) {
                curpath.push(node);
                if (node == p || node == q) {
                    if (path1.isEmpty()) {
                        path1 = new LinkedList<>(curpath);
                    } else {
                        return onFind();
                    }
                }
                node = node.left;
            }
            node = curpath.peek().right;
            while (node == lastNode || node == null) {
                lastNode = curpath.pop();
                if (curpath.size() <= 0) {
                    break;
                }
                node = curpath.peek().right;
            }
        }
        return null;
    }

    private TreeNode onFind() {
        Set<TreeNode> nodeSet = new HashSet<>(curpath);
        while (path1.size() > 0) {
            TreeNode node = path1.pop();
            if (nodeSet.contains(node)) {
                return node;
            }
        }
        return null;
    }

    //递归的方法

    //    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    //        if (root == null || root == p || root == q ) {
    //            return root;
    //        }
    //        TreeNode leftCommonAncestor =  lowestCommonAncestor(root.left, p, q);
    //        TreeNode rightCommonAncestor =  lowestCommonAncestor(root.right, p, q);
    //        //在左子树中没有找到，那一定在右子树中
    //        if(leftCommonAncestor == null){
    //            return rightCommonAncestor;
    //        }
    //        //在右子树中没有找到，那一定在左子树中
    //        if(rightCommonAncestor == null){
    //            return leftCommonAncestor;
    //        }
    //        //不在左子树，也不在右子树，那说明是根节点
    //        return root;
    //        }
    //    
    //        作者：windliang
    //        链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-5-2/
    //        来源：力扣（LeetCode）
    //        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    //    

    //    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
    //        find(root, p, q);
    //        TreeNode result = root;
    //        while (!path1.isEmpty()) {
    //            result = path1.removeLast();
    //            if (path2.contains(result)) {
    //                break;
    //            }
    //        }
    //        return result;
    //    }
    //
    //    public void find(TreeNode node, TreeNode p, TreeNode q) {
    //        if (!path2.isEmpty() && !path1.isEmpty()) {
    //            return;
    //        }
    //        curpath.add(node);
    //        if (node == p || node == q) {
    //            if (path1.isEmpty()) {
    //                path1 = new LinkedList<>(curpath);
    //            } else {
    //                path2 = new LinkedList<>(curpath);
    //                return;
    //            }
    //        }
    //        if (node.left != null) {
    //            find(node.left, p, q);
    //        }
    //        if (node.right != null) {
    //            find(node.right, p, q);
    //        }
    //        curpath.removeLast();
    //    }
}
