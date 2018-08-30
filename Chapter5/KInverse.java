package BATcourse.Chapter5;

/**
 * 链表的K逆序：
 * 有一个单链表，请设计一个算法，使得每K个节点之间逆序，如果最后不够K个节点一组，则不调整最后几个节点。
 * 例如链表1->2->3->4->5->6->7->8->null，K=3这个例子。调整后为，3->2->1->6->5->4->7->8->null。
 * 因为K==3，所以每三个节点之间逆序，但其中的7，8不调整，因为只有两个节点不够一组。
 * 给定一个单链表的头指针head,同时给定K值，返回逆序后的链表的头指针。
 */

/**
 * 解题思路：
 * （1）使用栈，空间复杂度O（K）
 * （2）记录每个需要调整的子链表的第一个结点，然后每到k个结点就进行一次逆序调整
 */
public class KInverse {
    public ListNode inverse(ListNode head, int k) {

        if (k < 2 || head.next == null)
            return head;
        ListNode current = head;
        ListNode previous = head;
        ListNode first = head;
        ListNode last = null;
        ListNode previousFirst = null;
        ListNode finalHead = null;//最终返回的值
        int counter = 1;

        while (current != null) {
            //保存前一节点的指针域
            ListNode tmp1 = current.next;

            //判断最后一组不够k个的结点
            if (tmp1 == null && counter % k != 0) {
                if (counter % k == 1 ) {
                    first.next = current;
                    break;
                }
                //
                previousFirst.next = first;
                //previous.next = current;
                current.next = null;
                ListNode save = previous;
                //不够k个的处理,pre为快指针
                ListNode pre = previous;
                while (previous != first) {
                    ListNode tmp2 = pre.next;
                    if (pre != previous)
                        pre.next = previous;
                    previous = pre;
                    pre = tmp2;
                }
                save.next = current;
                break;
            }
            //前一个first指向后一个last
            if (counter % k == 1) {
                previousFirst = first;
                //
                first = current;
                previous = current;
            }
            //
            if (counter % k == 0) {
                last = current;
            }
            //将每个子链表的头结点指向null
            if (counter % k == 1) {
                current.next = null;
            } else {
                current.next = previous;
            }
            //
            if (counter % k == 0) {
                if (counter == k)
                    finalHead = current;
                else
                    previousFirst.next = last;
            }
            previous = current;
            current = tmp1;
            counter++;
        }
        return finalHead;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
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
        KInverse kInverse = new KInverse();
        kInverse.inverse(node1, 2);
    }
}
