package BATcourse.Chapter4;

/**
 * 可查询最值的栈：
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 */

import java.util.Stack;

/**
 * 解题思路：
 * 1. 两个栈，一个为StackData，一个为StackMin。StackMin记录当前StackData中的最小元素值；
 */
public class Solution {

    Stack<Integer> stackData = new Stack<Integer>();
    Stack<Integer> stackMin = new Stack<Integer>();


    public void push(int node) {
        if (stackMin.empty() || stackMin.peek() > node){
            stackMin.push(node);
            stackData.push(node);
        }else {
            stackMin.push(stackMin.peek());
            stackData.push(node);
        }
    }

    public void pop() {
        stackData.pop();
        stackMin.pop();
    }

    public int top() {
        return stackData.peek();
    }

    public int min() {
        return stackMin.peek();
    }
}
