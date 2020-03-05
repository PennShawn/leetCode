package practices.algorithmCourse.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Description:
 *               Sort a linked list in O(n log n) time using constant space
 *               complexity.
 *
 *               Example 1:
 *
 *               Input: 4->2->1->3
 *               Output: 1->2->3->4
 *               Example 2:
 *
 *               Input: -1->5->3->4->0
 *               Output: -1->0->3->4->5
 * 
 *               思路：后续看看各种排序的代码
 * @Author: shenpeng
 * @Date: 2020-03-05
 */

//Definition for singly-linked list.

public class SortList {

    static class ListNode {

        int val;

        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode sortList(ListNode head) {
        if (head == null) {
            return head;
        }
        List<ListNode> listNodes = new ArrayList<>();
        while (head != null) {
            listNodes.add(head);
            head = head.next;
        }
        Collections.sort(listNodes, Comparator.comparing(o -> o.val));
        ListNode root = listNodes.get(0);

        for (int i = 1; i < listNodes.size(); i++) {
            root.next = listNodes.get(i);
            root = root.next;
        }
        root.next = null;
        return listNodes.get(0);
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        ListNode node = new ListNode(2);
        head.next = node;
        node.next = new ListNode(1);
        node = node.next;
        node.next = new ListNode(3);
        System.out.println(sortList(head).next.val);
    }

}
