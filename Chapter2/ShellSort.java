package BATcourse.Chapter2;
/**
 * 题目：对于一个int数组，请编写一个希尔排序算法，对数组元素排序。
 *      给定一个int数组A及数组的大小n，请返回排序后的数组。保证元素小于等于2000。
 */

//步长变化的插入排序
public class ShellSort {
    public int[] shellSort(int[] A, int n) {
        int step = n / 2;
        int tmp, index;
        //最外层的for循环为控制步长的循环
        while(step > 0) {
            //从第step个元素开始到最后一个元素，与步长长度之前的元素比较
            for (int i = step; i < A.length; i++) {
                index = i;
                while (true){
                    if ((index - step)< 0)
                        break;
                    if (A[index] < A[index - step]){
                        tmp = A[index];
                        A[index] = A[index - step];
                        A[index - step] = tmp;
                        index = index - step;
                    }
                    else
                        break;
                }
            }
            step = step / 2;
        }
        return A;
    }
}
