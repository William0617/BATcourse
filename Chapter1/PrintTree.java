package BATcourse.Chapter1;

import java.util.*;
/*
    1.2 二叉树打印练习题
    有一颗二叉树，请设计一个算法，按照层次打印这棵二叉树。
    给定二叉树的根节点root，请返回打印结果，结果按照每一层一个数组进行存储。
    所有数组的顺序按照层数从上往下，且每一层的数组内元素按照从左到右排列。保证节点数小于等于500.
*/
/**
 *  基本思想：
 *  1.将各结点值放入ArrayList，用字符串“NextLine”分割每一层
 *  创建一个队列，同时设置3个指针current（当前操作的结点），last（本层最后一个结点）和nLast（下一层的最后一个结点）。
 *  开始时，current和last指向根结点。将根结点入队，然后出队，出队的同时将该结点的值加入list中；
 *  寻找nLast：
 *  先判断当前结点是否有左孩子，如果有，将其加入队列，并将nLast置为该结点；
 *  再判断当前结点是否有孩右子，如果有，将其加入队列，并将nLast置为该结点；
 *  最后判断当前current是否是本层的最后一个结点（currentNode == last），如果是的话，将last置为下一层的nLast。
 *  2.将ArrayList中的值装入二维数组并返回
 */
public class PrintTree {

    public int[][] printTree(TreeNode root) {
        //队列用来筛选结点
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        //存储结点的值
        ArrayList<String> list = new ArrayList<String>();
        //将第一个根结点放入队列
        queue.add(root);
        //第一层的last结点是根节点
        TreeNode last = root;
        TreeNode nLast = null;
        TreeNode currentNode;
        while (!queue.isEmpty()) {

            currentNode = queue.poll();
            list.add(currentNode.val+"");

            if (currentNode.left != null) {
                queue.add(currentNode.left);
                nLast = currentNode.left;
            }
            if (currentNode.right != null) {
                queue.add(currentNode.right);
                nLast = currentNode.right;
            }
            if (currentNode == last) {
                last = nLast;
                list.add("NextLine");
            }
        }
        //有多少个NextLine就有多少个一维数组，数组存放在array中
        ArrayList<int[]> array = new ArrayList<int[]>();
        //找到第一个NextLine的索引值
        int index = list.indexOf("NextLine");
        //存放上一个NextLine的索引值
        int lastIndex = 0;
        //只要能够找到NextLine，就循环
        while(index != -1){
            //根结点要特殊处理，单独存一个数组
            if (index == 1){
                int[] temp = {root.val};
                array.add(temp);
            }
            else{
                //两个索引之间是一个新数组
                int[] temp = new int[index - lastIndex - 1];
                //将两个索引之间的值依次放入新数组
                for (int i = 0,j = lastIndex + 1 ; i < temp.length; ++i, ++j){
                    temp[i] = Integer.parseInt(list.get(j));
                }
                array.add(temp);
            }
            lastIndex = index;
            //不能直接remove,用空字符占位
            list.set(index, "");
            //获得下个NextLine索引值
            index = list.indexOf("NextLine");
        }
        //将array中的数组导入二维数组并返回
        int[][] result = new int[array.size()][];
        for (int i = 0; i < array.size(); ++i){
            result[i] = new int[array.get(i).length];
            for (int j = 0 ;j < result[i].length; ++j){
                int[] a = array.get(i);
                result[i][j] = a[j];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        PrintTree pt = new PrintTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        root.right.right.left = new TreeNode(9);
        pt.printTree(root);
        System.out.println(Arrays.deepToString(pt.printTree(root)));
    }
}
