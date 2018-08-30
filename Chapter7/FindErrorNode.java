package BATcourse.Chapter7;

/**
 * 寻找错误结点：
 * 一棵二叉树原本是搜索二叉树，但是其中有两个节点调换了位置，使得这棵二叉树不再是搜索二叉树，
 * 请找到这两个错误节点并返回他们的值。保证二叉树中结点的值各不相同。
 * 给定一棵树的根结点，请返回两个调换了位置的值，其中小的值在前。
 */
import java.util.*;


/**
 * 解题思路：中序遍历树，结果中第一次降序错的是大数,；第二次降序错的是小数；
 */
public class FindErrorNode {
    public int[] findError(TreeNode root) {
        int[] result = new int[2];
        List<TreeNode> list = new ArrayList<TreeNode>();
        inOrder(root, list);
        int flag = 1;
        for (int i = 0; (i+1) < list.size(); i++) {
            if (flag == 1 && list.get(i).val > list.get(i+1).val){
                flag++;
                result[0] = Math.max(list.get(i).val, list.get(i+1).val);
                //要考虑到第一个和第二个数交换的情况；
                result[1] = Math.min(list.get(i).val, list.get(i + 1).val);
                continue;
            }
            if (flag == 2 && list.get(i).val > list.get(i+1).val) {
                result[1] = Math.min(list.get(i).val, list.get(i + 1).val);
                break;
            }
        }
        int tmp;
        if (result[0] > result[1]){
            tmp = result[0];
            result[0] = result[1];
            result[1] = tmp;
        }
        return result;
    }

    private void inOrder(TreeNode root, List<TreeNode> list) {
        if (root == null)
            return;
        inOrder(root.left, list);
        list.add(root);
        inOrder(root.right, list);
    }
}
