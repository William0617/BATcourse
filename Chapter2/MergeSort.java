package BATcourse.Chapter2;
/**
 * 算法思想:
 * (1)归并排序首先将待排序数组或线性表分为两个有序数组或线性表
 * (2)将两个数组或线性表合并成一个有序数组或线性表.
 */

import java.util.*;

public class MergeSort {

    public int[] mergeSort(int[] A, int n) {
        return sort(A, 0, n - 1);
    }

    private int[] sort(int[] A, int low, int high) {
        if (high > low){
            int mid = (low + high) / 2;
            sort(A, low, mid);     //左边有序
            sort(A, mid + 1, high);//右边有序
            merge(A, low, mid, high);//左右合并
        }
        return A;
    }
    //C.length ? A.length?
    public void merge(int[] A, int low, int mid, int high) {
        int[] C = new int[high - low + 1];
        List<Integer> listA = new ArrayList<Integer>();
        List<Integer> listB = new ArrayList<Integer>();
        for (int i = low; i <= mid; ++i){
            listA.add(A[i]);
        }
        for (int i = mid + 1; i <= high; ++i){
            listB.add(A[i]);
        }
        int count= 0;
        while(!listA.isEmpty() && !listB.isEmpty()){
            if (listA.get(0) < listB.get(0)){
                C[count] = listA.remove(0);
            }else
                C[count] = listB.remove(0);
            count++;
        }
        if (!listA.isEmpty()){
            for (int i = 0; i < listA.size(); ++i){
                C[count] = listA.get(i);
                count++;
            }
        }
        if (!listB.isEmpty()){
            for (int i = 0; i < listB.size(); ++i){
                C[count] = listB.get(i);
                count++;
            }
        }
        //注意
        for (int i = 0; i < C.length; ++i){
            A[ i+low ] = C[i];
        }
    }


    //合并两个有序数组:
    //只要从比较二个数列的第一个数，谁小就先取谁。
    //取了后就在对应数列中删除这个数。然后再进行比较，如果有数列为空，那直接将另一个数列的数据依次取出即可。
    public int[] merge(int[] A, int[] B) {
        int[] C = new int[A.length + B.length];
        List<Integer> listA = new ArrayList<Integer>();
        List<Integer> listB = new ArrayList<Integer>();
        for (int i = 0; i < A.length; ++i){
            listA.add(A[i]);
        }
        for (int i = 0; i < B.length; ++i){
            listB.add(B[i]);
        }
        int count= 0;
        while(!listA.isEmpty() && !listB.isEmpty()){
            if (listA.get(0) < listB.get(0)){
                C[count] = listA.remove(0);
            }else
                C[count] = listB.remove(0);
            count++;
        }
        if (!listA.isEmpty()){
            for (int i = 0; i < listA.size(); ++i){
                C[count] = listA.get(i);
                count++;
            }
        }
        if (!listB.isEmpty()){
            for (int i = 0; i < listB.size(); ++i){
                C[count] = listB.get(i);
                count++;
            }
        }
        return C;
    }


}
