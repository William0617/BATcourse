package BATcourse.Chapter7;

/**
 * 判断完全二叉树：
 * 有一棵二叉树,请设计一个算法判断它是否是完全二叉树。
 * 给定二叉树的根结点root，请返回一个bool值代表它是否为完全二叉树。树的结点个数小于等于500。
 */
import java.util.*;

/**
 * 解题思路：
 * 1. 采用按层遍历的方式，依次遍历所有结点；
 * 2. 如果当前结点有右孩子没有左孩子，直接返回false;
 * 3. 如果当前结点有左孩子没有右孩子，那之后的结点必须为叶子结点，否则返回false；
 * 4. 如果之前步骤不返回false,则返回true;
 */
public class CheckCompletion {
    public boolean chk(TreeNode root) {
        if (root == null)
            return true;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        //标记位，判断是否需要判断当前结点为叶子结点；如果是true不要判断；是false则需要判断；
        boolean flag = true;
        queue.add(root);
        while (true){
            TreeNode tmp = queue.poll();
            //2. 如果当前结点有右孩子没有左孩子，直接返回false;
            if (tmp.left == null && tmp.right != null)
                return false;
            //3. 如果当前结点有左孩子没有右孩子，那之后的结点必须为叶子结点，否则返回false；
            if (tmp.left != null && tmp.right == null) {
                queue.add(tmp.left);
                flag = false;
                continue;
            }
            if(!flag){
                //tmp有左孩子或者右孩子，说明他不是叶子结点，返回false;
                if(tmp.left != null || tmp.right != null){
                    return false;
                }
            }

            if (tmp.left != null)
                queue.add(tmp.left);
            if (tmp.right != null)
                queue.add(tmp.right);
            if (queue.isEmpty())
                break;
        }
        return true;
    }
}
