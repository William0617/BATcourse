package BATcourse.Chapter6;

/**
 * 完全二叉树练习题：
 * 给定一棵完全二叉树的根节点root，返回这棵树的节点个数。如果完全二叉树的节点数为N，请实现时间复杂度低于O(N)的解法。
 * 给定树的根结点root，请返回树的大小。
 */


/**
 * 解题思路：一半用公式，一半用递归。
 */
public class CountNodes {
    public int count(TreeNode root) {
        if (root.left == null)
            return 1;
        //1. 统计左树的深度；
        int leftLevel = 0;
        TreeNode tmp = root;
        while (tmp != null){
            leftLevel++;
            tmp = tmp.left;
        }
        //2. 统计右树最左孩子的深度；
        int rightLevel = 0;
        tmp = root.right;
        while (tmp != null){
            rightLevel++;
            tmp = tmp.left;
        }
        //3.如果右树深度能够与左树相同，则公式计算左树总结点数加上递归计算右树节点数；
        int total;
        if (leftLevel == rightLevel){
            total = 1 + (int)Math.pow(2, leftLevel) - 1;
            total = total + getOtherSide(root.right);
            return total;
        }
        //4.如果右树深度与左树不相同，则公式计算右树总结点数加上递归计算左树节点数；
        total = 1 + (int)Math.pow(2, rightLevel) - 1 + getOtherSide(root.left);
        return total;
    }

    private int getOtherSide(TreeNode root) {
        if (root.left == null)
            return 1;
        int total;
        total = 1 + getOtherSide(root.left) + getOtherSide(root.right);
        return total;
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