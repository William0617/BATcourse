package BATcourse.Chapter2;

/**
 * （非递归堆排序）
 * 请设计一个高效算法，判断数组中是否有重复值。必须保证额外空间复杂度为O(1)。
 * 给定一个int数组A及它的大小n，请返回它是否有重复值。
 */
public class Checker {
    public boolean checkDuplicate(int[] a, int n) {
        // write code here
        for (int i = a.length - 1; i >= 0; i--) {
            heapSort(a, i);
            swap(a, 0, i);
        }
        for (int j = 1; j < a.length; j++) {
            if (a[j - 1] == a[j])
                return true;
        }
        return false;
    }

    //构建堆
    public int[] heapSort(int[] a, int lastIndex) {
        int current = lastIndex;
        int parent = (int) Math.floor((current - 1) / 2);
        int leftChild,rightChild;
        int change;
        while (current >= 0) {
            leftChild = 2 * current + 1;
            rightChild = 2 * current + 2;
            if(hasParent(current)){
                if (a[current] > a[parent]) {
                    swap(a, current, parent);
                    change = parent;
                    //需要递归判断换位置后与左右结点大小情况
                    while (hasChildren(a, change, lastIndex)){
                        change = judge(a, change, lastIndex);
                    }
                }
            }
            if (hasLeftChild(current, lastIndex)){
                if (a[leftChild] > a[current]) {
                    swap(a, leftChild, current);
                    change = leftChild;
                    //判断change情况
                    while (hasChildren(a, change, lastIndex)){
                        change = judge(a, change, lastIndex);
                    }
                }
            }
            if (hasRightChild(current, lastIndex)){
                if (a[rightChild] > a[current]) {
                    swap(a, rightChild, current);
                    change = rightChild;
                    while (hasChildren(a, change, lastIndex)){
                        change = judge(a, change, lastIndex);
                    }
                }
            }
            current--;
        }
        return a;
    }

    private boolean hasParent(int current) {
        int parent = (int) Math.floor((current - 1) / 2);
        if (parent >= 0)
            return true;
        return false;
    }

    private boolean hasLeftChild(int current, int lastIndex) {

        int leftChild = 2 * current + 1;
        if (leftChild > 0 && leftChild < lastIndex)
            return true;
        return false;
    }

    private boolean hasRightChild(int current, int lastIndex) {

        int rightChild = 2 * current + 2;
        if (rightChild > 0 && rightChild < lastIndex)
            return true;
        return false;
    }
    //判断current是否有左右子结点
    private int judge(int[] a, int current, int lastIndex) {
        int parent = (int) Math.floor(current - 1) / 2;
        int leftChild = 2 * current + 1;
        int rightChild = 2 * current + 2;
        int change = -1;
        if(hasParent(current)){
            if (a[current] > a[parent]) {
                swap(a, current, parent);
                change = parent;
            }
        }
        if (hasLeftChild(current, lastIndex)){
            if (a[leftChild] > a[current]) {
                swap(a, leftChild, current);
                //判断change情况
                change = leftChild;
            }
        }
        if (hasRightChild(current, lastIndex)){
            if (a[rightChild] > a[current]) {
                swap(a, rightChild, current);
                change = rightChild;
            }
        }
        return change;
    }

    private boolean hasChildren(int[] a, int current, int lastIndex) {
        if (current < 0)
            return false;
        int leftChild = 2 * current + 1;
        int rightChild = 2 * current + 2;
        if (leftChild <= lastIndex || rightChild <= lastIndex)
            return true;
        return false;
    }

    private void swap(int[] A, int a, int b) {
        int tmp;
        tmp = A[a];
        A[a] = A[b];
        A[b] = tmp;
    }

}
