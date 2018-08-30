package BATcourse.Chapter2;

/**
 * 求最短未排序子数组：
 * 对于一个数组，请设计一个高效算法计算需要排序的最短子数组的长度。
 * 给定一个int数组A和数组的大小n，请返回一个二元组，代表所求序列的长度。
 * (原序列位置从0开始标号,若原序列有序，返回0)。保证A中元素均为正整数。
 */
public class Subsequence {
    public int shortestSubsequence(int[] A, int n) {
        // write code here
        int left = 0, right = 0, currentMax = A[0], currentMin = A[n-1], current = 0;
        for (int i = 0; i < n; i++) {
            if (currentMax < A[i]){
                currentMax = A[i];
            }
            if (currentMax > A[i]){
                right = i;
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            if (currentMin > A[i]){
                currentMin = A[i];
            }
            if (currentMin < A[i]){
                left = i;
            }
        }
        if (right- left == 0)
            return 0;
        return right-left+1;
    }
}
