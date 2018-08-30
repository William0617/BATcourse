package BATcourse.Chapter5;

/**
 * 打印两个链表的公共值：
 * 现有两个升序链表，且链表中均无重复元素。请设计一个高效的算法，打印两个链表的公共值部分。
 * 给定两个链表的头指针headA和headB，请返回一个vector，元素为两个链表的公共部分。
 * 请保证返回数组的升序。两个链表的元素个数均小于等于500，且保证一定有公共值。
 */

import java.util.ArrayList;

/**
 * 解题思路：
 * 为每个链表设置一个指针，A和B。分别遍历链表，较小的结点的指针往后移动；若相等，则一起往后移动。
 */
public class Common {
    public int[] findCommonParts(ListNode headA, ListNode headB) {
        // write code here
        if (headA == null || headB == null)
            return null;
        ListNode a = headA;
        ListNode b = headB;
        ArrayList<Integer> list = new ArrayList<Integer>();
        while (a != null && b != null){
            if (a.val > b.val)
                a = a.next;
            else if (a.val < b.val)
                b = b.next;
            else {
                list.add(a.val);
                a = a.next;
                b = b.next;
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        return result;

    }
}
