package BATcourse.Chapter5;

/**
 * 无环单链表判断相交：
 * 现在有两个无环单链表，若两个链表的长度分别为m和n，请设计一个时间复杂度为O(n + m)，
 * 额外空间复杂度为O(1)的算法，判断这两个链表是否相交。
 * 给定两个链表的头结点headA和headB，请返回一个bool值，代表这两个链表是否相交。保证两个链表长度小于等于500。
 */

/**
 * 解题思路：
 * 先遍历得到两个链表的长度A和B；
 * 较长的链表先走|A-B|，然后一起走看是否相交。
 */
public class CheckIntersect {
    public boolean chkIntersect(ListNode headA, ListNode headB) {
        ListNode A = headA;
        int counterA = 0;
        ListNode B = headB;
        int counterB = 0;
        while (A != null){
            counterA++;
            A = A.next;
        }
        while (B != null){
            counterB++;
            B = B.next;
        }
        A = headA;
        B = headB;
        ListNode commonNode = null;
        if (counterA > counterB){
            int tmp = counterA - counterB;
            while (tmp != 0){
                tmp--;
                A = A.next;
            }
            while (A.next != null){
                if (A == B){
                    commonNode = A;
                    return true;
                }
                A = A.next;
                B = B.next;
            }
            return false;
        }
        else {
            int tmp = counterB - counterA;
            while (tmp != 0){
                tmp--;
                B = B.next;
            }
            while (B.next != null){
                if (A == B){
                    commonNode = B;
                    return true;
                }
                A = A.next;
                B = B.next;
            }
            return false;
        }
    }
}
