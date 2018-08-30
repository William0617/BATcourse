package BATcourse.Chapter2;

/**
 * 小范围排序联系：（改进后的堆排序，小根堆）
 * 已知一个几乎有序的数组，几乎有序是指，如果把数组排好顺序的话，每个元素移动的距离可以不超过k，
 * 并且k相对于数组来说比较小。请选择一个合适的排序算法针对这个数据进行排序。
 * 给定一个int数组A，同时给定A的大小n和题意中的k，请返回排序后的数组。
 */
public class ScaleSort {
    public int[] sortElement(int[] A, int n, int k) {
        if (A == null || A.length == 0 || n < k) {
            return A;
        }
        int[] heap = new int[k];
        for (int i = 0; i <= n - k; i++) {
            createHeap(A, heap, i);
        }

        return A;
    }

    private void createHeap(int[] a, int[] heap, int start) {
        for (int i = 0; i < heap.length; i++) {
            heap[i] = a[i + start];
        }
        sort(heap);
        for (int i = 0; i < heap.length; i++) {
            a[start+i] = heap[i];
        }
    }

    //用了个数组解决最小数字存放问题
    private void sort(int[] A) {
        int current = A.length - 1, parent, leftChild, rightChild, change;
        while (current >= 0){
            parent = (int)Math.floor((current - 1) / 2);
            leftChild = 2 * current + 1;
            rightChild = 2 * current + 2;
            if (hasParent(current) && A[current] < A[parent]){
                swap(A, current, parent);
                change = parent;
                while(hasLeftChild(A, change) || hasRightChild(A, change)){
                    change = subSort(A,change);
                }
            }
            if (hasLeftChild(A, current) && A[leftChild] < A[current]){
                swap(A, current, leftChild);
                change = leftChild;
                while(hasLeftChild(A, change) || hasRightChild(A, change)){
                    change = subSort(A, change);
                }

            }
            if (hasRightChild(A, current) && A[rightChild] < A[current]){
                swap(A, current, rightChild);
                change = rightChild;
                while(hasLeftChild(A, change) || hasRightChild(A, change)){
                    change = subSort(A, change);
                }
            }
            current--;
        }
    }

    private int subSort(int[] A, int current) {
        int parent = (int)Math.floor((current - 1) / 2);
        int leftChild = 2 * current + 1;
        int rightChild = 2 * current + 2;
        int change = -1;
        if (hasParent(current) && A[current] < A[parent]){
            swap(A, current, parent);
            change = parent;
        }
        if (hasLeftChild(A, current) && A[leftChild] < A[current]){
            swap(A, current, leftChild);
            change = leftChild;

        }
        if (hasRightChild(A,current) && A[rightChild] < A[current]){
            swap(A, current, rightChild);
            change = rightChild;
        }
        return change;
    }

    private boolean hasRightChild(int[] A, int current) {
        int rightChild = 2 * current + 2;
        if (rightChild < A.length - 1 && rightChild > 0)
            return true;
        return false;
    }

    private boolean hasLeftChild(int[] A, int current) {
        int leftChild = 2 * current + 1;
        if (leftChild < A.length - 1 && leftChild > 0)
            return true;
        return false;
    }

    private boolean hasParent(int current) {
        int parent = (int)Math.floor((current - 1) / 2);
        return parent >= 0;
    }

    private void swap(int[] A, int a, int b) {
        int tmp;
        tmp = A[a];
        A[a] = A[b];
        A[b] = tmp;
    }
}
