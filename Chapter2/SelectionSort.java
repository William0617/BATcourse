package BATcourse.Chapter2;

public class SelectionSort {

    public int[] selectionSort(int[] A, int n) {
        int min, index, tmp;
        for (int i = 0; i < A.length; i++) {
            min = A[i];//最小值要更新，不然第一次取完就一直最小了，无法继续进行了
            index = -1;//index也要更新，否则一直不等于-1了，乱交换；
            for (int j = i + 1; j < A.length; j++) {
                if (A[j] < min){
                    min = A[j];
                    index = j;
                }
            }
            //
            if (index != -1){
                tmp = A[i];
                A[i] = A[index];
                A[index] = tmp;
            }
        }
        return A;
    }
      //以前只知道互换，错误！！
//    public int[] selectionSort(int[] A, int n) {
//        int min;
//        for (int i = 0; i < n; ++i) {
//            for (int j = i; j < n; ++j) {
//                if (A[i] > A[j]) {
//                    min = A[j];
//                    A[j] = A[i];
//                    A[i] = min;
//                }
//            }
//        }
//        return A;
//    }
}
