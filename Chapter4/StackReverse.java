package BATcourse.Chapter4;

import java.util.Stack;

/**
 * 栈的反转：
 * 实现一个栈的逆序，但是只能用递归函数和这个栈本身的pop操作来实现，而不能自己申请另外的数据结构。
 * 给定一个整数数组A即为给定的栈，同时给定它的大小n，请返回逆序后的栈
 */
public class StackReverse {

    public int[] reverseStack(int[] A, int n) {
        Stack<Integer> stack = new Stack<Integer>();
        // write code here
        for (int i = 0; i < A.length; i++) {
            stack.push(A[i]);
        }
        reverseStack(stack);
        for (int i = A.length-1; i >= 0; i--) {
            A[i] = stack.pop();
        }
        return A;
    }

    private Stack<Integer> reverseStack(Stack<Integer> stack) {
        if (stack.isEmpty())
            return stack;
        int tmp = getBottomElement(stack);
        reverseStack(stack);
        stack.push(tmp);
        return stack;
    }

    //获取栈的最底层元素并弹出返回，然后将剩余元素下移；
    private int getBottomElement(Stack<Integer> stack){
        int result = stack.pop();
        if (stack.isEmpty())
            return result;
        else {
            int tmp = getBottomElement(stack);
            stack.push(result);
            return tmp;
        }
    }
}
