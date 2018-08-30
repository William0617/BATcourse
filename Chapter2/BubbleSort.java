package BATcourse.Chapter2;

public class BubbleSort {
        public int[] bubbleSort(int[] A, int n) {
            int tmp;
            for (int i = 0; i < n; ++i){
                for (int j = 0; j + 1 < n - i; ++j){
                    if (A[j] > A[j + 1]){
                        tmp = A[j + 1];
                        A[j + 1] = A[j];
                        A[j] = tmp;
                    }
                }
            }
            return A;
        }
}