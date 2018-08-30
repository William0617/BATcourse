package BATcourse.Chapter5;

/**
 * 复杂链表的复制：
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点）。
 */

/**
 * 解题思路：
 * 将新复制的结点与原结点串一起；
 *
 * 注意：random指针可以为空。
 * 注意：输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */
public class Solution {
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null)
            return null;
        //在原链表中加入新复制的结点；
        RandomListNode before = pHead;
        int index  = 0;
        while (before != null){
            RandomListNode tmp = before.next;
            RandomListNode newNode = new RandomListNode(before.label);
            before.next = newNode;
            newNode.next = tmp;
            before = tmp;
        }
        //拷贝随机指针
        RandomListNode oldIndex = pHead;
        RandomListNode newIndex = pHead.next;
        while (newIndex != null){
            //存在random为空的情况
            if (oldIndex.random != null)
                newIndex.random = oldIndex.random.next;
            else
                newIndex.random = null;
            if (newIndex.next == null)
                break;
            oldIndex = oldIndex.next.next;
            newIndex = newIndex.next.next;
        }
        //拆解复制的链表
        RandomListNode oldOne = pHead;
        RandomListNode newOne = pHead.next;
        RandomListNode preOld = pHead;
        RandomListNode preNew = pHead.next;
        RandomListNode result = pHead.next;
        while (newOne != null){

            if (preNew != newOne){
                preNew.next = newOne;
            }
            if (preOld != oldOne){
                preOld.next = oldOne;
            }
            if (newOne.next == null) {
                //此处必须将原链表恢复完毕，否则OG报错；（原链表最后一个值指向null）
                oldOne.next = null;
                break;
            }
            preOld = oldOne;
            oldOne = oldOne.next.next;
            preNew = newOne;
            newOne = newOne.next.next;
        }
        return result;
    }

    public static void main(String[] args) {
        RandomListNode node1 = new RandomListNode(1);
        RandomListNode node2 = new RandomListNode(2);
        RandomListNode node3 = new RandomListNode(3);
        RandomListNode node4 = new RandomListNode(4);
        RandomListNode node5 = new RandomListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        node1.random = node3;
        node2.random = node5;
        node3.random = null;
        node4.random = node2;
        node5.random = null;

        Solution solution = new Solution();
        solution.Clone(node1);
    }
}


class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}

