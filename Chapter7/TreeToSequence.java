package BATcourse.Chapter7;

/**
 * 递归遍历二叉树：
 * 请用递归方式实现二叉树的先序、中序和后序的遍历打印。
 * 给定一个二叉树的根结点root，请依次返回二叉树的先序，中序和后续遍历(二维数组的形式)。
 */
import java.util.*;

public class TreeToSequence {
    public int[][] convert(TreeNode root) {
        List<Integer> preOrder = new ArrayList<Integer>();
        List<Integer> inOrder = new ArrayList<Integer>();
        List<Integer> postOrder = new ArrayList<Integer>();
        preOder(root, preOrder);
        inOrder(root, inOrder);
        postOrder(root, postOrder);
        int[][] result = new int[3][preOrder.size()];
        for (int i = 0; i < preOrder.size(); i++) {
            result[0][i] = preOrder.get(i);
            result[1][i] = inOrder.get(i);
            result[2][i] = postOrder.get(i);
        }
        return result;
    }

    private void postOrder(TreeNode root, List<Integer> postOrder) {
        if (root == null)
            return;
        postOrder(root.left, postOrder);
        postOrder(root.right, postOrder);
        postOrder.add(root.val);
    }

    private void inOrder(TreeNode root, List<Integer> inOrder) {
        if (root == null)
            return;
        inOrder(root.left, inOrder);
        inOrder.add(root.val);
        inOrder(root.right, inOrder);
    }

    private void preOder(TreeNode root, List<Integer> preOder) {
        if (root == null)
            return;
        preOder.add(root.val);
        preOder(root.left, preOder);
        preOder(root.right, preOder);
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
        TreeToSequence treeToSequence = new TreeToSequence();
        System.out.println(Arrays.deepToString(treeToSequence.convert(root)));
    }
}

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}