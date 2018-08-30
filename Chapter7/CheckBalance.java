package BATcourse.Chapter7;

/**
 * 平衡（AVL）二叉树判断：
 * 有一棵二叉树，请设计一个算法判断这棵二叉树是否为平衡二叉树。
 * 给定二叉树的根结点root，请返回一个bool值，代表这棵树是否为平衡二叉树。
 * (平衡二叉树定义：（1）空树是平衡二叉树；（2）左右子树高度差不超过1；)
 */

/**
 * 解题思路：二叉树的遍历。二叉树很多题目都是用递归遍历的代码改写的。
 * 1. 先判断左子树是不是AVL，不是直接返回false；
 * 2. 如果左子树是AVL，再去遍历右子树。遍历的同时收集两个信息：最深到哪一层，和是否是AVL。
 */
public class CheckBalance {
    public boolean check(TreeNode root) {
        Info res = checkAVL(root);
        return res.isBalance;
    }

    private Info checkAVL(TreeNode root) {
        if (root == null) {
            return new Info(0, true);
        }
        //1. 判断左树是否平衡，如果不平衡，直接返回false;
        Info left = checkAVL(root.left);
        if (!left.isBalance) {
            return new Info(0, false);
        }
        //2. 判断右树是否平衡，如果不平衡，直接返回false;
        Info right = checkAVL(root.right);
        if (!right.isBalance) {
            return new Info(0, false);
        }
        //3.左右树都平衡，算层级差；
        if (Math.abs(left.level - right.level) > 1) {
            return new Info(0, false);
        }
        //如何确认我的高度？？左右树中，最大的那个加1就是我的高度
        return new Info(Math.max(left.level, right.level)+1, true);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        root.left = null;
        root.right = node2;
        node2.left = node3;
        node2.right = null;
        node3.right = null;
        node3.left = null;
        CheckBalance checkBalance = new CheckBalance();
        checkBalance.check(root);
    }
}

class Info {

    public int level;
    public boolean isBalance;

    public Info() {
    }

    public Info(int level, boolean isBalance) {
        this.level = level;
        this.isBalance = isBalance;
    }
}
