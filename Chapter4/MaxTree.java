package BATcourse.Chapter4;

/**
 * 数组变MaxTree：
 * 对于一个没有重复元素的整数数组，请用其中元素构造一棵MaxTree，MaxTree定义为一棵二叉树，
 * 其中的节点与数组元素一一对应，同时对于MaxTree的每棵子树，它的根的元素值为子树的最大值。
 * 现有一建树方法，对于数组中的每个元素，
 * 其在树中的父亲为数组中它左边比它大的第一个数和右边比它大的第一个数中更小的一个。
 * 若两边都不存在比它大的数，那么它就是树根。请设计O(n)的算法实现这个方法。
 * 给定一个无重复元素的数组A和它的大小n，请返回一个数组，
 * 其中每个元素为原数组中对应位置元素在树中的父亲节点的编号，若为根则值为-1。
 */
import java.util.*;

/**
 * 解题思路：使用栈，收集每个数的左边和右边大于它本身的第一个数，然后生成树。
 * 题目给出生成规则：每个数的父结点是他左边第一个比他大的数和右边比他大的数中较小的那个。
 * 1. 使用栈数据结构，
 */
public class MaxTree {
    public int[] buildMaxTree(int[] A, int n) {

        Stack<Integer> stack = new Stack<Integer>();
        Map<Integer, Integer> left = new HashMap<Integer, Integer>();
        Map<Integer, Integer> right = new HashMap<Integer, Integer>();
        getLeftFirstBigger(A, n, stack, left);
        getRightFirstBigger(A, n, stack, right);
        return generateTree(A, left, right);
    }

    private int[] generateTree(int[] A, Map<Integer, Integer> left, Map<Integer, Integer> right) {
        int[] result = new int[A.length];
        Map<Integer, Integer> tmp = new HashMap<Integer, Integer>();
        for (int i = 0; i < A.length; i++) {
            tmp.put(A[i],i);
        }
        for (int i = 0; i < A.length; i++) {
            int index = A[i];
            if (left.get(index) == null && right.get(index) != null)
                result[i] = tmp.get(right.get(index));
            else if (left.get(index) != null && right.get(index) == null)
                result[i] = tmp.get(left.get(index));
            else if (left.get(index) == null && right.get(index) == null)
                result[i] = -1;
            else
                result[i] = tmp.get(Math.min(left.get(index), right.get(index)));
        }
        return result;
    }

    private void getRightFirstBigger(int[] A, int n, Stack<Integer> stack, Map<Integer, Integer> right) {
        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            if (stack.isEmpty()) {
                stack.push(A[i]);
                continue;
            }
            if(A[i] < stack.peek()) {
                right.put(A[i], stack.peek());
                stack.push(A[i]);
            }
            else{
                while(!stack.isEmpty() && stack.peek() < A[i]){
                    int tmp = stack.pop();
                    if (stack.isEmpty())
                        right.put(tmp, null);
                }
                if (stack.isEmpty())
                    stack.push(A[i]);
                else {
                    right.put(A[i], stack.peek());
                    stack.push(A[i]);
                }
            }
        }
        right.put(stack.firstElement(), null);
    }

    private void getLeftFirstBigger(int[] A, int n, Stack<Integer> stack, Map<Integer, Integer> left) {
        for (int i = 0; i < n; i++) {
            if (stack.isEmpty()) {
                stack.push(A[i]);
                continue;
            }
            if(A[i] < stack.peek()) {
                left.put(A[i], stack.peek());
                stack.push(A[i]);
            }
            else{
                while(!stack.isEmpty() && stack.peek() < A[i]){
                    int tmp = stack.pop();
                    if (stack.isEmpty())
                        left.put(tmp, null);
                }
                if (stack.isEmpty())
                    stack.push(A[i]);
                else {
                    left.put(A[i], stack.peek());
                    stack.push(A[i]);
                }
            }
        }
        left.put(stack.firstElement(), null);
    }

    public static void main(String[] args) {
        MaxTree maxTree = new MaxTree();
        int[] A = {3,1,4,2};
        maxTree.buildMaxTree(A,A.length);
    }
}
