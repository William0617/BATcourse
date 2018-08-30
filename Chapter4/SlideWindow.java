package BATcourse.Chapter4;

/**
 * 滑动窗口练习题：
 * 有一个整型数组 arr 和一个大小为 w 的窗口从数组的最左边滑到最右边,窗口每次向右边滑一个位置。
 * 返回一个长度为n-w+1的数组res，res[i]表示每一种窗口状态下的最大值。 以数组为[4,3,5,4,3,3,6,7]，w=3为例。
 * 因为第一个窗口[4,3,5]的最大值为5，第二个窗口[3,5,4]的最大值为5，第三个窗口[5,4,3]的最大值为5。第四个窗口[4,3,3]的最大值为4。
 * 第五个窗口[3,3,6]的最大值为6。第六个窗口[3,6,7]的最大值为7。所以最终返回[5,5,5,4,6,7]。
 * 给定整形数组arr及它的大小n，同时给定w，请返回res数组。保证w小于等于n，同时保证数组大小小于等于500。
 */
import java.util.*;

/**
 * 解题思路：使用双端队列qmax存放数组的下标值
 * 一、qmax进队规则：
 * 1.如果qmax为空，直接把下标i放入qmax；
 * 2.如果qmax不为空，取出qmax队尾存放的下标j。如果arr[j]>arr[i],直接把i放入队尾；
 * 3.如果arr[j]<=arr[i],则一直从qmax队尾弹出下标，直到队列中某个对应值大于arr[i]，把i放入队尾；
 * 二、qmax出队规则：
 * 1.如果qmax队头下标等于i-w，弹出当前qmax队头下标；
 *
 * */
public class SlideWindow {
    public int[] slide(int[] arr, int n, int w) {
        Deque<Integer> qmax = new LinkedList<Integer>();
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            //出队规则
            if (!qmax.isEmpty() && qmax.getFirst() == i - w)
                qmax.removeFirst();
            //入队规则
            if (qmax.isEmpty())
                qmax.add(i);
            else{
                int j = qmax.getLast();
                if (arr[j] > arr[i])
                    qmax.addLast(i);
                else {
                    while (true) {
                        qmax.removeLast();
                        if (qmax.isEmpty()) {
                            qmax.add(i);
                            break;
                        }
                        j = qmax.getLast();
                        if (arr[j] > arr[i]){
                            qmax.addLast(i);
                            break;
                        }
                    }
                }
            }
            //最大值始终在队头
            if (i >= w - 1)
                result.add(qmax.getFirst());
        }

        int[] res = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            res[i] = arr[result.get(i)];
        }
        return res;
    }

    public static void main(String[] args) {
        SlideWindow slideWindow = new SlideWindow();
        int[] a = {4,3,5,4,3,3,6,7};
        slideWindow.slide(a, 8, 3);
    }
}
