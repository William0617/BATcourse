package BATcourse.Chapter2;
/**
 * 三色国旗问题：
 * 有一个只由0，1，2三种元素构成的整数数组，请使用交换、原地排序而不是使用计数进行排序。
 * 给定一个只含0，1，2的整数数组A及它的大小，请返回排序后的数组。保证数组大小小于等于500。
 */

//较为复杂，不是最优解
public class ThreeColor {
    public int[] sortThreeColor(int[] A, int n) {
        // write code here
        if (A.length == 0)
            return A;
        int current = 0, zero = -1, two = n;
        while (current < two && current > zero) {
            if (A[current] == 0){
                while(current > zero && current < two){
                    if (A[current] == 0)
                        swap(A, ++zero, current);
                    if (A[current] == 2)
                        swap(A, --two, current);
                    if (A[current] == 1)
                        break;
                }
            }
            if (A[current] == 2){
                //如果数组中只有0和2，没有1，那么循环如何停下来？
                while(current > zero && current < two){
                    if (A[current] == 0)
                        swap(A, ++zero ,current);
                    if (A[current] == 2)
                        swap(A, --two, current);
                    if (A[current] == 1)
                        break;
                }
            }
            current++;
        }
        return A;
    }

    private void swap(int[] A, int a, int b) {
        int tmp;
        tmp = A[b];
        A[b] = A[a];
        A[a] = tmp;
    }
}