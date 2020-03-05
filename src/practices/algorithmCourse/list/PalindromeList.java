package practices.algorithmCourse.list;

/**
 * @Description:
 *               Given a singly linked list, determine if it is a
 *               palindrome.
 *
 *               Example 1:
 *
 *               Input: 1->2
 *               Output: false
 *               Example 2:
 *
 *               Input: 1->2->2->1
 *               Output: true
 *               Follow up:
 *               Could you do it in O(n) time and O(1) space?
 * 
 *               不用递归方法反转的话空间复杂度就是O(1)了，递归需要额外的堆栈帧空间，所以空间复杂度是O(n)
 * 
 * @Author: shenpeng
 * @Date: 2020-03-05
 */
public class PalindromeList {

    // Definition for singly-linked list.
    class ListNode {

        int val;

        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    int size = 0;

    int reverseSize;

    ListNode tail;

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        } else {
            reverse(head);
        }
        System.out.println(size);
        System.out.println(reverseSize);
        ListNode node1 = head;
        ListNode node2 = tail;
        for (int i = 0; i < reverseSize; i++) {
            if (node1.val != node2.val) {
                return false;
            }
            node1 = node1.next;
            node2 = node2.next;
        }
        return true;
    }

    public ListNode reverse(ListNode head) {
        size++;
        if (head.next.next == null) {
            tail = head.next;
        } else {
            reverse(head.next);
        }
        if (reverseSize < (size + 1) / 2) {
            head.next.next = head;
            head.next = null;//这一步一定不能忘
            reverseSize++;
        }

        return head;
    }
}
