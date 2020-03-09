package main.practices.algorithmCourse.list;

/**
 * @Description:
 *               https://leetcode-cn.com/explore/interview/card/top-interview-quesitons/265/linked-list/1146/
 * 
 *               Given a linked list, determine if it has a cycle in it.
 *
 *               To represent a cycle in the given linked list, we use an
 *               integer pos which represents the position (0-indexed) in
 *               the linked list where tail connects to. If pos is -1, then
 *               there is no cycle in the linked list.
 *
 *
 *
 *               Example 1:
 *
 *               Input: head = [3,2,0,-4], pos = 1
 *               Output: true
 *               Explanation: There is a cycle in the linked list, where
 *               tail connects to the second node.
 *
 *
 *               Example 2:
 *
 *               Input: head = [1,2], pos = 0
 *               Output: true
 *               Explanation: There is a cycle in the linked list, where
 *               tail connects to the first node.
 *
 *
 *               Example 3:
 *
 *               Input: head = [1], pos = -1
 *               Output: false
 *               Explanation: There is no cycle in the linked list.
 *
 *
 *
 *
 *               Follow up:
 *
 *               Can you solve it using O(1) (i.e. constant) memory?
 * 
 *               思路：双指针。O(1)
 * @Author: shenpeng
 * @Date: 2020-03-05
 */
//Definition for singly-linked list.
class ListNode {

    int val;

    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class HasCycle {

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode node1 = head;
        if (head.next == null) {
            return false;
        }
        node1 = head.next;
        while (head != null) {
            if (node1 == null) {
                return false;
            } else if (node1 == head) {
                return true;
            }
            node1 = node1.next;
            if (node1 == null) {
                return false;
            } else if (node1 == head) {
                return true;
            }
            head = head.next;
            node1 = node1.next;
        }
        return false;
    }
}
