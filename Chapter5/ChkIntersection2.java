package BATcourse.Chapter5;

/**
 * 单链表相交判断练习题：
 * 给定两个单链表的头节点head1和head2，如何判断两个链表是否相交？相交的话返回true，不想交的话返回false。
 * 给定两个链表的头结点head1和head2(注意，另外两个参数adjust0和adjust1用于调整数据,与本题求解无关)。
 * 请返回一个bool值代表它们是否相交。
 */

/**
 * 解题思路：3种情况
 * 0. 先判断两个链表有没有环；
 * 1. 两个无环链表；
 * 2. 一个有环一个无环；(不可能相交)
 * 3. 两个都有环；
 */
public class ChkIntersection2 {
    public boolean chkInter(ListNode head1, ListNode head2, int adjust0, int adjust1) {
        //0. 先判断两个链表有没有环；
        ListNode isLoop1 = chkLoop(head1);
        ListNode isLoop2 = chkLoop(head2);
        //1. 两个无环链表；
        if (isLoop1 == null && isLoop2 == null) {
            return chkIntersect(head1, head2);
        }
        //3. 两个都有环；
        else if (isLoop1 != null && isLoop2 != null)
            return chkLoopInter(head1, head2);
        //2. 一个有环一个无环；(不可能相交)
        else
            return false;
    }

    //2. 两个都有环；
    public boolean chkLoopInter(ListNode head1, ListNode head2) {
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

    //1. 无环单链表相交判断
    public static boolean chkIntersect(ListNode headA, ListNode headB) {
        ListNode A = headA;
        int counterA = 0;
        ListNode B = headB;
        int counterB = 0;
        while (A != null) {
            counterA++;
            A = A.next;
        }
        while (B != null) {
            counterB++;
            B = B.next;
        }
        A = headA;
        B = headB;
        ListNode commonNode = null;
        if (counterA > counterB) {
            int tmp = counterA - counterB;
            while (tmp != 0) {
                tmp--;
                A = A.next;
            }
            while (A.next != null) {
                if (A == B) {
                    commonNode = A;
                    return true;
                }
                A = A.next;
                B = B.next;
            }
            return false;
        } else {
            int tmp = counterB - counterA;
            while (tmp != 0) {
                tmp--;
                B = B.next;
            }
            while (B.next != null) {
                if (A == B) {
                    commonNode = B;
                    return true;
                }
                A = A.next;
                B = B.next;
            }
            return false;
        }
    }

    //0. 判断是否有环，有环则拿到入环结点
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