package BATcourse.Chapter2;
/**
 * 算法思想：
 * （1）最大堆调整（Max-Heapify）：将堆的末端子节点作调整，使得子节点永远小于父节点
 * （2）创建最大堆（Build-Max-Heap）：将堆所有数据重新排序，使其成为最大堆
 * （3）堆排序（Heap-Sort）：移除位在第一个数据的根节点，并做最大堆调整的递归运算
 */

public class HeapSort {
    public int[] heapSort(int[] A, int n) {
        int tmp, count = A.length;
        //如何每次传入A值不同
        for (int j = 0; j < A.length; j++) {
            for (int i = count- 1; i >= 0; i--) {
                compareChildren(A, i, count);
            }
            tmp = A[0];
            A[0] = A[count - 1];
            A[count - 1] = tmp;
            count--;
        }
        return A;
    }
    //比较当前结点与子结点，小于子结点就交换,count取数组元素的个数
    void compareChildren(int[] A, int current, int count) {
        int tmp;
        int parent = (int) Math.floor((current - 1) / 2);
        int leftChild = 2 * current + 1;
        int rightChild = 2 * (current + 1);
        if (parent >= 0 && A[current] > A[parent]) {
            tmp = A[parent];
            A[parent] = A[current];
            A[current] = tmp;
            compareChildren(A, parent,count);
        }
        if ((leftChild <= count - 1) && A[leftChild] > A[current]) {
            tmp = A[leftChild];
            A[leftChild] = A[current];
            A[current] = tmp;
            compareChildren(A, leftChild, count);
        }
        if ((rightChild <= count - 1) && A[rightChild] > A[current]) {
            tmp = A[rightChild];
            A[rightChild] = A[current];
            A[current] = tmp;
            compareChildren(A, rightChild, count);
        }
    }
}
