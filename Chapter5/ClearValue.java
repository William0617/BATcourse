package BATcourse.Chapter5;

/**
 * 链表指定值清除：
 * 现在有一个单链表。链表中每个节点保存一个整数，再给定一个值val，把所有等于val的节点删掉。
 * 给定一个单链表的头结点head，同时给定一个值val，
 * 请返回清除后的链表的头结点，保证链表中有不等于该值的其它值。请保证其他元素的相对顺序。
 */

/**
 * 解题思路：
 * 遍历老链表，用不等于val的结点构建新链表。
*/
public class ClearValue {
    public ListNode clear(ListNode head, int val) {
        // write code here
        ListNode first = null, last = null;
        //一个flag
        int counter = 1;
        while (head != null){
//            ListNode tmp = head.next;
            if (head.val != val && counter == 1) {
                first = head;
                last = first;
                counter++;
            }
            else if (head.val != val && counter != 1){
                last.next = head;
                last = last.next;
            }
//            else if (head.val == val && counter != 1){
//                continue;
//            }
//            else if (head.val == val && counter == 1){
//
//            }

            head = head.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        ListNode node8 = new ListNode(8);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = null;
        ClearValue clearValue = new ClearValue();
        clearValue.clear(node1,2);
    }
}