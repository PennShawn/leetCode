package practices.algorithmCourse.list;

/**
 * @Description:
 *               https://leetcode-cn.com/explore/interview/card/top-interview-quesitons/265/linked-list/1145/
 * 
 *               A linked list is given such that each node contains an
 *               additional random pointer which could point to any node in
 *               the list or null.
 *
 *               Return a deep copy of the list.
 *
 *               The Linked List is represented in the input/output as a
 *               list of n nodes. Each node is represented as a pair of
 *               [val, random_index] where:
 *
 *               val: an integer representing Node.val
 *               random_index: the index of the node (range from 0 to n-1)
 *               where random pointer points to, or null if it does not
 *               point to any node.
 *
 *
 *               Example 1:
 *
 *
 *               Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 *               Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
 *               Example 2:
 *
 *
 *               Input: head = [[1,1],[2,1]]
 *               Output: [[1,1],[2,1]]
 *               Example 3:
 *
 *
 *
 *               Input: head = [[3,null],[3,0],[3,null]]
 *               Output: [[3,null],[3,0],[3,null]]
 *               Example 4:
 *
 *               Input: head = []
 *               Output: []
 *               Explanation: Given linked list is empty (null pointer), so
 *               return null.
 *
 *
 *               Constraints:
 *
 *               -10000 <= Node.val <= 10000
 *               Node.random is null or pointing to a node in the linked
 *               list.
 *               Number of Nodes will not exceed 1000.
 * 
 *               思路：这题可以优化一下实现O(n)复杂度，用一个map将<originNode,curNode>存起来，之后要找random的时候就不用遍历了
 * @Author: shenpeng
 * @Date: 2020-03-05
 */

// Definition for a Node.
class Node {

    int val;

    Node next;

    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class CopyRandomList {

    Node originRoot;

    Node curRoot;

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        originRoot = head;
        curRoot = new Node(head.val);
        Node curNode = curRoot;
        while (head.next != null) {
            head = head.next;
            curNode.next = new Node(head.val);
            curNode = curNode.next;
        }
        Node originNode;
        for (curNode = curRoot, originNode = originRoot; curNode != null; curNode = curNode.next, originNode = originNode.next) {
            Node curNode2 = curRoot;
            Node originNode2 = originRoot;
            if (originNode.random == null) {
                curNode.random = null;
                continue;
            }
            while (originNode.random != null) {
                if (originNode.random == originNode2) {
                    curNode.random = curNode2;
                    break;
                } else {
                    originNode2 = originNode2.next;
                    curNode2 = curNode2.next;
                }
            }
        }
        return curRoot;
    }
}
