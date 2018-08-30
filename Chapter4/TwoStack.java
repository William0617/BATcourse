package BATcourse.Chapter4;

/**
 * 双栈构造队列：
 * 编写一个类,只能用两个栈结构实现队列,支持队列的基本操作(push，pop)。
 * 给定一个操作序列ope及它的长度n，其中元素为正数代表push操作，
 * 为0代表pop操作，保证操作序列合法且一定含pop操作，请返回pop的结果序列。
 */

import java.util.*;

/**
 * 注意事项：
 * 1. 每次倒入时，要一次性全部倒入；
 * 2. 如果stackPop不为空，则不能发生倒数据行为；
 */
public class TwoStack {

    public int[] twoStack(int[] ope, int n) {
        // write code here
        Stack<Integer> stackPush = new Stack<Integer>();
        Stack<Integer> stackPop = new Stack<Integer>();
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            //保证第一条
            if (ope[i] != 0) {
                stackPush.push(ope[i]);
            } else {
                //保证第二条
                if (stackPop.empty()) {
                    while (!stackPush.empty())
                        stackPop.push(stackPush.pop());
                }
                tmp.add(stackPop.pop());
            }
        }
        int[] result = new int[tmp.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = tmp.get(i);
        }
        return result;
    }
}
