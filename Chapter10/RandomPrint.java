package BATcourse.Chapter10;

/**
 * 随机数组打印问题：
 * 给定一个长度为N且没有重复元素的数组arr和一个整数M，实现函数等概率随机打印arr中的M种数字。
 */

/**
 * 解题思路：
 * （1）在0-N-1随机取一个位置a;
 * （2）把arr[a]和arr[N-1]交换；
 * （3）在0-N-2随机取一个位置b;
 * （4）把arr[b]和arr[N-2]交换；
 * （5）直到打印M个为止；
 * */
public class RandomPrint {
    public int[] print(int[] arr, int N, int M) {
        if (M == 0 || N == 0)
            return null;
        int pos;
        int count = 0, copy = N;
        int[] result = new int[M];
        while (count < M){
            pos = (int)(copy-- * Math.random());
            result[count] = arr[pos];
            swap(arr, pos, copy);
            count++;
        }
        return result;
    }

    private void swap(int[] arr, int pos, int copy) {
        int tmp;
        tmp = arr[pos];
        arr[pos] = arr[copy];
        arr[copy] = tmp;
    }
}
