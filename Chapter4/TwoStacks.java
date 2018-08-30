package BATcourse.Chapter4;

/**
 * 双栈排序：
 * 请编写一个程序，按升序对栈进行排序（即最大元素位于栈顶），
 * 要求最多只能使用一个额外的栈存放临时数据，但不得将元素复制到别的数据结构中。
 * 给定一个int[] numbers(C++中为vector&ltint>)，其中第一个元素为栈顶，请返回排序后的栈。
 * 请注意这是一个栈，意味着排序过程中你只能访问到第一个元素。
 */
import java.util.*;

/**
 * 解题思路：
 * 1.两个stack，如果help为空，则讲stack中元素直接放入；
 * 2.如果help中不为空，则判断stack的pop的元素与help.peek()的大小：
 * （1）如果大于，则直接放入；
 * （2）如果小于，则将help中的元素pop到stack中，直到大于，然后将stack的pop元素放入，再将刚才help弹出的元素放入
 * 3.直到stack为空，以上结束;
 */
public class TwoStacks {
    public ArrayList<Integer> twoStacksSort(int[] numbers) {
        Stack<Integer> stack = new Stack<Integer>();
        Stack<Integer> help = new Stack<Integer>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < numbers.length; i++) {
            stack.push(numbers[i]);
        }
        while(!stack.isEmpty()){
            int tmp = stack.pop();
            if (help.isEmpty())
                help.push(tmp);
            else{
                if (help.peek() <= tmp)
                    help.push(tmp);
                else{
                    int count = 0;
                    //此处要判断help是否为空
                    while (!help.isEmpty() && help.peek() > tmp){
                        stack.push(help.pop());
                        count++;
                    }
                    help.push(tmp);                    
                    while(count != 0){
                        help.push(stack.pop());
                        count--;
                    }
                }
            }
        }
        while (!help.isEmpty())
            list.add(help.pop());
        return list;
    }
}
