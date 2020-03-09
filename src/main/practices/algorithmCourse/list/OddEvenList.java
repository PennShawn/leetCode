package main.practices.algorithmCourse.list;

/**
 * @Description:
 *               Given a singly linked list, group all odd nodes together
 *               followed by the even nodes. Please note here we are
 *               talking about the node number and not the value in the
 *               nodes.
 *
 *               You should try to do it in place. The program should run
 *               in O(1) space complexity and O(nodes) time complexity.
 *
 *               Example 1:
 *
 *               Input: 1->2->3->4->5->NULL
 *               Output: 1->3->5->2->4->NULL
 *               Example 2:
 *
 *               Input: 2->1->3->5->6->4->7->NULL
 *               Output: 2->3->6->7->1->5->4->NULL
 *               Note:
 *
 *               The relative order inside both the even and odd groups
 *               should remain as it was in the input.
 *               The first node is considered odd, the second node even and
 *               so on ...
 * @Author: shenpeng
 * @Date: 2020-03-06
 */

public class OddEvenList {

    // Definition for singly-linked list.
    class ListNode {

        int val;

        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode preOddNode = head;
        ListNode oddNode = head.next.next;
        ListNode preEvenNode = head.next;
        ListNode evenNode = head.next;
        while (oddNode != null) {
            evenNode.next = oddNode.next;
            oddNode.next = preEvenNode;
            preOddNode.next = oddNode;

            preOddNode = oddNode;
            evenNode = evenNode.next;
            if (evenNode != null) {
                oddNode = evenNode.next;
            } else {
                break;
            }
        }
        return head;
    }
}
