package BATcourse.Chapter5;

/**
 * 有环单链表相交问题：
 * 如何判断两个有环单链表是否相交？相交的话返回第一个相交的节点，不想交的话返回空。
 * 如果两个链表长度分别为N和M，请做到时间复杂度O(N+M)，额外空间复杂度O(1)。
 * 给定两个链表的头结点head1和head2(注意，另外两个参数adjust0和adjust1用于调整数据,与本题求解无关)。
 * 请返回一个bool值代表它们是否相交。
 */

/**
 * 解题思路：几种情况
 * 1. 两个链表的入环结点是同一个，则相交；但是相交结点可能在如环结点之前。参考两个无环单链表找相交结点，
 * 用入环结点当作终止条件；
 * 2. 两个链表的入环结点不同一个，有两种结果。
 * （1）两个链表不相交；
 * （2）相交，但是两个链表入环结点分别为环上的不同结点；
 * 如果判断以上两种情况呢？第一个链表从入环结点开始，走一圈，没碰到第二个链表的入环位置，则为第一种；遇到了为第二种。
 */
public class ChkIntersection {
    public boolean chkInter(ListNode head1, ListNode head2, int adjust0, int adjust1) {
        // write code here
        ListNode a = chkLoop(head1);
        ListNode b = chkLoop(head2);
        ListNode insectNode = null;
        if (a == b) {
            //TODO:保存相交结点
            return true;
        }
        ListNode copyA = a.next;

        while (copyA != a) {
            if (copyA == b) {
                insectNode = copyA;
                return true;
            }
            copyA = copyA.next;
        }
        return false;
    }

    public static ListNode chkLoop(ListNode head) {
        int result = -1;
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null) {
            slow = slow.next;
            //这一步判断不可缺少
            if (fast.next == null)
                break;
            fast = fast.next.next;
            if (slow == fast) {
                result = 0;
                break;
            }
        }
        if (result == 0) {
            fast = head;
            while (fast != slow) {
                fast = fast.next;
                slow = slow.next;
            }
            return fast;
        } else
            return null;
    }
}