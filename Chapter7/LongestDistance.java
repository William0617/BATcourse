package BATcourse.Chapter7;

/**
 * 树上最远距离练习题：
 * 从二叉树的节点A出发，可以向上或者向下走，但沿途的节点只能经过一次，当到达节点B时，路径上的节点数叫作A到B的距离。
 * 对于给定的一棵二叉树，求整棵树上节点间的最大距离。
 * 给定一个二叉树的头结点root，请返回最大距离。保证点数大于等于2小于等于500.
 */

/**
 * 解题思路：
 * 最大距离只可能有三种情况：
 * （1）root左子树的最大距离；
 * （2）root右子树的最大距离；
 * （3）root左子树上离root左孩子最远结点的距离，加上root自身；再加上root右子树上离root右孩子最远结点的距离
 * 三个中，最大的即为所求。
 */
public class LongestDistance {
    public int findLongest(TreeNode root) {
        Max res = postOrder(root);
        return res.max1;
    }

    private Max postOrder(TreeNode root) {
        if (root == null)
            return new Max(0, 0);
        //处理左子树得到两个信息：左子树的最大距离Lmax1 = Lmax2 + 1，距离root.left最远的距离Lmax2
        Max Lmax = postOrder(root.left);
        //处理右子树得到两个信息：右子树的最大距离Rmax1 = Rmax2 + 1，距离root.right最远的距离Rmax2
        Max Rmax = postOrder(root.right);
        //跨越root的最大距离为，Lmax2+Rmax2+1;
        return new Max(Math.max(Lmax.max2 + Rmax.max2 + 1, Math.max(Lmax.max1, Rmax.max1)),
                Math.max(Lmax.max2+1, Rmax.max2+1));
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4= new TreeNode(1);
        TreeNode node5 = new TreeNode(4);

        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node2.right = null;
        node3.right = null;
        node3.left = node5;
        node4.left = null;
        node4.right = null;
        node5.left = null;
        node5.right = null;
        LongestDistance l = new LongestDistance();
        l.findLongest(root);
    }
}

class Max {

    public int max1;
    public int max2;

    public Max(int max1, int max2) {
        this.max1 = max1;
        this.max2 = max2;
    }
}
