package BATcourse.Chapter2;

/**
 * 桶排序思想的两种实现：基数排序和计数排序。
 */
public class BucketSort {

    //基数排序,元素<=2000
    public int[] radixSort(int[] A, int n) {
        int[][] bucket = new int[10][n];
        putElement(A, bucket);
        return A;
    }

    //元素等于0的情况？？
    private void putElement(int[] A, int[][] bucket) {
        int digit = 1;
        while (digit != 1000) {
            int remainder;
            int[] count = new int[10];
            for (int i = 0; i < A.length; i++) {
                remainder = (A[i] / digit) % 10;
                bucket[remainder][count[remainder]++] = A[i];
            }
            getElement(bucket, A, count);
            digit = digit * 10;
        }
    }

    private void getElement(int[][] bucket, int[] A, int[] count) {
        int num = 0;
        for (int i = 0; i < bucket.length; i++) {
            //j < count[i]，如果没有计数就不赋值。
            for (int j = 0; j < count[i]; j++) {
                //要考虑到元素为0的情况啊
                A[num++] = bucket[i][j];
            }
        }
    }

    //计数排序
    public int[] countingSort(int[] A, int n) {

        int max = max(A);
        int[] B = new int[max + 1];
        for (int i = 0; i < A.length; i++) {
            B[A[i]]++;
        }
        int indexA = 0;
        for (int i = 0; i < B.length; i++) {
            if (B[i] != 0) {
                for (int j = 0; j < B[i]; j++) {
                    A[indexA] = i;
                    indexA++;
                }
            }
        }
        return A;
    }

    private int max(int[] A) {
        int max = A[0], tmp;
        for (int i = 1; i < A.length; i++) {
            if (A[i] > max) {
                //此处不能交换，否则改变了A数组的元素位置
                max = A[i];
            }
        }
        return max;
    }
}
