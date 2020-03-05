package practices.algorithmCourse.list;

/**
 * @Description:
 *               Reverse a singly linked list.
 *
 *               Example:
 *
 *               Input: 1->2->3->4->5->NULL
 *               Output: 5->4->3->2->1->NULL
 *               Follow up:
 *
 *               A linked list can be reversed either iteratively or
 *               recursively. Could you implement both?
 * 
 *               刚开始几次提交一直报超出内存限制的错,后来发现是tm的初始的头节点head.next没有置为null,
 *               判题时应该是会把最终的list输出一遍，所以打印的时候就死循环了
 * @Author: shenpeng
 * @Date: 2020-03-05
 */
public class ReverseList {

    // Definition for singly-linked list.
    static class ListNode {

        int val;

        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    ListNode root;

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        } else {
            reverse(head);
            return root;
        }
    }

    public ListNode reverse(ListNode head) {
        System.out.println(head.val);
        if (head.next.next == null) {
            root = head.next;
        } else {
            reverseList(head.next);
        }
        head.next.next = head;

        head.next = null;//这一步一定不能忘

        return head;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ReverseList reverseList = new ReverseList();
        reverseList.reverseList(node1);
    }

}
