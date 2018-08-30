package BATcourse.Chapter5;

/**
 * 链表的分化练习：
 * 对于一个链表，我们需要用一个特定阈值完成对它的分化，使得小于等于这个值的结点移到前面，
 * 大于该值的结点在后面，同时保证两类结点内部的位置关系不变。
 * 给定一个链表的头结点head，同时给定阈值val，请返回一个链表，
 * 使小于等于它的结点在前，大于等于它的在后，保证结点值不重复。
 */

/**
 * 解题思路：
 * 分解成三个小链表，然后首尾相连即为所得
 */
public class Divide {
    public ListNode listDivide(ListNode head, int val) {
        // write code here
        if (head == null)
            return null;
        ListNode current = head;
        ListNode smaller = null, bigger = null, equal = null;
        ListNode headSmaller = null, headBigger = null, headEqual = null;

        while (current != null) {
            if (current.val <= val) {
                if (smaller == null) {
                    smaller = new ListNode(current.val);
                    //并未受到smaller变化的影响；
                    headSmaller = smaller;
                }
                else {
                    smaller.next = new ListNode(current.val);
                    smaller = smaller.next;
                }
            }
            else if (current.val >= val){
                if (bigger == null) {
                    bigger = new ListNode(current.val);
                    headBigger = bigger;
                }
                else {
                    bigger.next = new ListNode(current.val);
                    bigger = bigger.next;
                }
            }
            else{
                if (equal == null) {
                    equal = new ListNode(current.val);
                    headEqual = equal;
                }
                else {
                    equal.next = new ListNode(current.val);
                    equal = equal.next;
                }
            }
            current = current.next;
        }

        //
        if (smaller != null) {
            if (equal != null){
                smaller.next = headEqual;
                if (bigger != null)
                    equal.next = headBigger;
            }
            else
                smaller.next = headBigger;
            return headSmaller;
        }
        else {
            if (equal != null) {
                equal.next = headBigger;
                return headEqual;
            }
            return headBigger;
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;

        Divide divide = new Divide();
        divide.listDivide(node1,3);
    }
}
