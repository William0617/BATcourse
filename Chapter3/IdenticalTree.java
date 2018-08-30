package BATcourse.Chapter3;

/**
 * 对于两棵彼此独立的二叉树A和B，请编写一个高效算法，检查A中是否存在一棵子树与B树的拓扑结构完全相同。
 * 给定两棵二叉树的头结点A和B，请返回一个bool值，代表A中是否存在一棵同构于B的子树。
 */

/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}*/
//想明白为什么这么递归？？
public class IdenticalTree {

    public boolean chkIdentical(TreeNode A, TreeNode B) {
        //递归终止条件：
        //都为空相等
        if (A == null && B == null)
            return true;
        //一个为空一个不为空不相等
        if (A == null || B == null)
            return false;
        //判断是否完全等于
        if (identify(A, B))
            return true;
        //从左孩子以下的子树是否与B相等
        if(chkIdentical(A.left, B))
            return true;
        //从右孩子以下的子树是否与B相等
        if (chkIdentical(A.right, B))
            return true;
        return false;
    }

    //判断两个树是否完全相等（顺序地递归比较他们的左右孩子）
    private boolean identify(TreeNode A, TreeNode B) {
        if (A == null && B == null)
            return true;
        if (A == null || B == null)
            return false;
        if (A.val == B.val && identify(A.left, B.left) && identify(A.right, B.right)) {
            return true;
        }
        return false;
    }


}