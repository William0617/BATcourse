package BATcourse.Chapter2;
/**
 * 有序数组合并练习：
 * 有两个从小到大排序以后的数组A和B，其中A的末端有足够的缓冲空容纳B。请编写一个方法，将B合并入A并排序。
 * 给定两个有序int数组A和B，A中的缓冲空用0填充，同时给定A和B的真实大小int n和int m，请返回合并后的数组。
 */

public class Merge {
    //注意，m和n是真实大小！！
    public int[] mergeAB(int[] A, int[] B, int n, int m) {
        // write code here
        int indexA = n - 1, indexB = m - 1, putIndex = A.length - 1;
        while (true) {
            //数组B剩下的最后一个元素要处理
//            if (putIndex < 0 || indexA < 0 || indexB < 0){
//                break;
//            }
            if (A[indexA] >= B[indexB]) {
                A[putIndex--] = A[indexA--];
            }
            //如果其中一个数组复制完毕，另外一个数组剩余的数直接复制进A
            if (indexA == -1){
                for (int i = 0; i <= indexB; i++) {
                    A[i] = B[i];
                }
                break;
            }
            //下面使用了上面改变的指针，造成错误
            if (A[indexA] < B[indexB]) {
                A[putIndex--] = B[indexB--];
            }
            if (indexB == -1)
                break;
        }
        return A;
    }
}
