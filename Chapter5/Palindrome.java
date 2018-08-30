package BATcourse.Chapter5;

/**
 * 链表的回文结构：
 * 请编写一个函数，检查链表是否为回文。
 * 给定一个链表ListNode pHead，请返回一个bool，代表链表是否为回文。
 */

/**
 * 解题思路：
 * 最优解用逆序。
 */
public class Palindrome {
    public boolean isPalindrome(ListNode pHead) {
        // 找到中心结点
        boolean result = true;
        ListNode fast = pHead, slow = pHead;
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast == null)
                break;
            else
                fast = fast.next;
        }
        //链表右部分逆序
        ListNode previous = slow;
        ListNode current = slow;
        while (current != null) {
            ListNode tmp = current.next;
            if (previous != current) {
                current.next = previous;
            }
            previous = current;
            current = tmp;
        }
        slow.next = null;
        //左右开始比对
        ListNode rightHead = previous;
        ListNode leftHead = pHead;
        while (rightHead != null) {
            if (leftHead.val != rightHead.val){
                result = false;
                break;
            }
            leftHead = leftHead.next;
            rightHead = rightHead.next;
        }
        //调整回原状
        //链表右部分逆序
        ListNode previous1 = previous;
        ListNode current1 = previous;
        while (current1 != null) {
            ListNode tmp = current1.next;
            if (previous1 != current1) {
                current1.next = previous1;
            }
            previous1 = current1;
            current1 = tmp;
        }
        previous.next = null;
        return result;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(3);
        ListNode node7 = new ListNode(2);
        ListNode node8 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = null;
        node8.next = null;
        Palindrome palindrome = new Palindrome();
        palindrome.isPalindrome(node1);
    }
}
