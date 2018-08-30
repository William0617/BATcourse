package BATcourse.Chapter7;

/**
 * 折纸练习题：(非最优解，不如老师写的好)
 * 请把纸条竖着放在桌⼦上，然后从纸条的下边向上⽅对折，压出折痕后再展开。
 * 此时有1条折痕，突起的⽅向指向纸条的背⾯，这条折痕叫做“下”折痕 ；突起的⽅向指向纸条正⾯的折痕叫做“上”折痕。
 * 如果每次都从下边向上⽅ 对折，对折N次。请从上到下计算出所有折痕的⽅向。
 * 给定折的次数n,请返回从上到下的折痕的数组，若为下折痕则对应元素为"down",若为上折痕则为"up".
 */

import java.util.*;

/**
 * 解题思路：
 * 树的右中左遍历。
 */
public class FoldPaper {
    public String[] foldPaper(int n) {
        if (n == 0)
            return null;
        // 1. 生成二叉树
        int nodes = ((int) Math.pow(2, n)) - 1;
        Node[] arr = new Node[nodes];
        int index = 0;
        //生成结点
        while (nodes > 0) {
            if (nodes % 2 == 1) {
                arr[index++] = new Node("down");
            }
            if (nodes % 2 == 0) {
                arr[index++] = new Node("up");
            }
            nodes--;
        }
        //连接结点
        for (int i = 0; (2*i+2) < arr.length; i++) {
            Node node = arr[i];
            node.left = arr[2*i+1];
            node.right = arr[2*i+2];
        }
        //2. 遍历二叉树
        List<Node> list = new ArrayList<Node>();
        helper(list, arr[0]);
        String[] res = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
             res[i] = list.get(i).val;
        }
        return res;
    }

    public void helper(List<Node> list, Node head) {
        if (head == null)
            return;
        helper(list, head.right);
        list.add(head);
        helper(list, head.left);
    }

    public static void main(String[] args) {
        FoldPaper foldPaper = new FoldPaper();
        System.out.println(Arrays.toString(foldPaper.foldPaper(5)));
    }
}

class Node {
    String val = "";
    Node left = null;
    Node right = null;

    public Node(String val) {
        this.val = val;
    }
}