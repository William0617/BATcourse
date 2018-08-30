package BATcourse.Chapter2;

public class InsertionSort {
    public int[] insertionSort(int[] A, int n) {
        // currentIndex非常重要
        int tmp, currentIndex;
        for (int i = 0; i < n; ++i){
            currentIndex = i;
            for (int j = i - 1; j >= 0; --j){
                if (A[currentIndex] < A[j]){
                    //交换后值发生变化了，索引需要更新！！如果前面有多个小与A[i]要交换多次
                    tmp = A[j];
                    A[j] = A[currentIndex];
                    A[currentIndex] = tmp;
                    currentIndex--;
                }
            }
        }
        return A;
    }
}