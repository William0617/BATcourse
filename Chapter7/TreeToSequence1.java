package BATcourse.Chapter7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 非递归二叉树遍历：
 * 请用非递归方式实现二叉树的先序、中序和后序的遍历打印。
 * 给定一个二叉树的根结点root，请依次返回二叉树的先序，中序和后续遍历(二维数组的形式)。
 */
public class TreeToSequence1 {

    public int[][] convert(TreeNode root) {
        Stack<TreeNode> preOrder = new Stack<TreeNode>();
        Stack<TreeNode> inOrder = new Stack<TreeNode>();
        Stack<TreeNode> postOrder = new Stack<TreeNode>();
        List<Integer> a = new ArrayList<Integer>();
        List<Integer> b = new ArrayList<Integer>();
        List<Integer> c = new ArrayList<Integer>();

        preOrder(root, preOrder, a);
        inOrder(root, inOrder, b);
        postOrder(root, postOrder, c);
        int[][] result = new int[3][a.size()];
        for (int i = 0; i < a.size(); i++) {
            result[0][i] = a.get(i);
            result[1][i] = b.get(i);
            result[2][i] = c.get(i);
        }
        return result;
    }

    /**
     * 1. 将头结点入栈
     * 2. 每次弹出栈顶结点current，存储current结点的值；
     * 3. 如果current右孩子不为空，将其入栈；
     * 4. 然后如果current左孩子不为空，将其入栈；
     * 5. 不断重复2-4直到stack为空
     *
     * @param root
     * @param preOrder
     */
    private void preOrder(TreeNode root, Stack<TreeNode> preOrder, List<Integer> a) {
        preOrder.push(root);
        while (!preOrder.isEmpty()) {
            TreeNode current = preOrder.pop();
            a.add(current.val);
            if (current.right != null)
                preOrder.push(current.right);
            if (current.left != null)
                preOrder.push(current.left);
        }
    }

    /**
     * 1. 先把current结点入栈，对以current结点为头的整个子树来说，依次把整棵树的左边界入栈，
     * 即不断地使current=current.left,然后重复步骤1;
     * 2. 重复步骤1，如果current为空，则从stack中弹出一个结点node，保存node的值，并让current = node.right，
     * 重复步骤1；
     * 3. 当栈为空并且current也为空，整个过程结束；
     * @param root
     * @param inOrder
     * @param b
     */
    private void inOrder(TreeNode root, Stack<TreeNode> inOrder, List<Integer> b) {
        TreeNode current = root;
        inOrder.push(current);
        while(true){
            if (current != root)
                inOrder.push(current);
            current = current.left;
            //需要循环判断
            while (current == null) {
                TreeNode node = inOrder.pop();
                b.add(node.val);
                current = node.right;
                if (current == null && inOrder.isEmpty())
                    return;
            }
        }
    }

    /**
     * 1. 先将头结点压入栈，设置变量h和c,h表示最近一次弹出并存储的结点，c表示当前栈的栈顶结点；
     * 初始时，h为头结点，c为null；
     * 2. 每次令c等于当前stack的栈顶结点，但是不从stack弹出结点，此时有三种情况：
     * （1）如果c的左孩子不为空，并且h不等于c的左孩子，也不等于c的右孩子，则把c的左孩子入栈；
     * （2）如果1不成立，并且c的右孩子不为空，并且h不等于c的右孩子，则把c的右孩子压入栈；
     * （3）如果1和2都不成立，那么从stack中弹出c并打印，然后令h等于c;
     * 3. 一直重复步骤2，直到stack为空，停止；
     * @param root
     * @param postOrder
     * @param list
     */
    private void postOrder(TreeNode root, Stack<TreeNode> postOrder, List<Integer> list) {
        //最近一次弹出并存储的结点
        TreeNode h = root;
        //c表示当前栈的栈顶结点
        TreeNode c = null;
        postOrder.push(root);

        while (!postOrder.isEmpty()) {
            c = postOrder.peek();
            if (c.left != null && h != c.left && h != c.right)
                postOrder.push(c.left);
            else if (c.right != null && h != c.right)
                postOrder.push(c.right);
            else {
                TreeNode node = postOrder.pop();
                list.add(node.val);
                h = c;
            }

        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(132);
        TreeNode node1 = new TreeNode(11);
        TreeNode node2 = new TreeNode(375);
        TreeNode node3 = new TreeNode(625);
        TreeNode node4 = new TreeNode(225);
        TreeNode node5 = new TreeNode(416);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        TreeToSequence1 treeToSequence = new TreeToSequence1();
        System.out.println(Arrays.deepToString(treeToSequence.convert(root)));
    }
}
