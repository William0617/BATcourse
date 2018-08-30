package BATcourse.Chapter5;
/**
 * 判断链表有无环：
 * 如何判断一个单链表是否有环？有环的话返回进入环的第一个节点的值，无环的话返回-1。
 * 如果链表的长度为N，请做到时间复杂度O(N)，额外空间复杂度O(1)。
 * 给定一个单链表的头结点head（注意另一个参数adjust为加密后的数据调整参数，方便数据设置，与本题求解无关)，
 * 请返回所求值。
 */

/**
 * 解题思路：快慢指针。
 * 快指针每次走两步，慢指针每次走一步先判断是否有环；
 * 相遇后，快指针回到头结点，慢指针继续，快慢都走一步，相遇的点就是环的第一个点。
 */
public class ChkLoop {
    public int chkLoop(ListNode head, int adjust) {
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
            return fast.val;
        } else
            return result;
    }
}