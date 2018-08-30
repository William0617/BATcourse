package BATcourse.Chapter7;

/**
 * 二叉树打印：
 * 有一棵二叉树，请设计一个算法，按照层次打印这棵二叉树。
 * 给定二叉树的根结点root，请返回打印结果，结果按照每一层一个数组进行储存，
 * 所有数组的顺序按照层数从上往下，且每一层的数组内元素按照从左往右排列。保证结点数小于等于500。
 */
import java.util.*;

/**
 * 解题思路：双指针+队列。
 */
public class TreePrinter {
    public int[][] printTree(TreeNode root) {
        if (root == null)
            return null;
        TreeNode last = root;
        TreeNode nLast = root;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        //先用map存储，再存入数组中；
        Map<Integer, String> map = new HashMap<Integer, String>();
        int index = 0;
        queue.add(root);
        while (true) {
            //打印点。要用tmp,他表示的是每次从队列中出来的值；
            TreeNode tmp = queue.poll();
            if (map.get(index) != null)
                map.put(index, map.get(index)+" "+tmp.val);
            else
                map.put(index, tmp.val+"");

            if (tmp.left != null) {
                queue.add(tmp.left);
                nLast = tmp.left;
            }
            if (tmp.right != null) {
                queue.add(tmp.right);
                nLast = tmp.right;
            }
            if (last == tmp) {
                last = nLast;
                index++;
            }
            if (queue.isEmpty())
                break;
        }
        int[][] result = new int[map.size()][];
        for (int i = 0; i < result.length; i++) {
            String[] tmp = map.get(i).split(" ");
            int[] array = new int[tmp.length];
            for (int j = 0; j < array.length; j++) {
                array[j] = Integer.valueOf(tmp[j]);
            }
            result[i] = array;
        }
        return result;
    }
}
