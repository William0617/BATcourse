package BATcourse.Chapter5;

/**
 * 访问单个节点的删除问题：
 * 实现一个算法，删除单向链表中间的某个结点，假定你只能访问该结点。
 * 给定带删除的头节点和要删除的数字，请执行删除操作，返回删除后的头结点。链表中没有重复数字
 */

/**
 * 解题思路：
 * 假如有3个结点1->2->3->null：现在要删掉2结点，那么直接将结点3拷贝到结点2的位置然后指向null即可。
 * 可以只划分为2个链表，我的作法有点麻烦。
 */
public class Remove {
    public ListNode removeNode(ListNode pNode, int delVal) {
        // write code here
        if (pNode == null)
            return null;
        if (pNode.val == delVal)
            return pNode.next;
        ListNode temp = pNode;
        ListNode node = pNode;
        while (node != null){
            //这里就是复制后一个节点，然后删除后一个节点的做法
            if (node.val == delVal && node.next != null){
                //此处注意顺序！！！！先换值，否则会为空！
                node.val = node.next.val;
                node.next = node.next.next;
                return pNode;
            }
            else if (node.val == delVal && node.next == null){
                temp.next = null;
                return pNode;
            }
            temp = node;
            node = node.next;
        }
        return pNode;
    }
}

