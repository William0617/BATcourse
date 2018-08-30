package BATcourse.Chapter6;

/**
 * 循环有序数组最小值练习：（不易理解）
 * 对于一个有序循环数组arr，返回arr中的最小值。
 * 有序循环数组是指，有序数组左边任意长度的部分放到右边去，右边的部分拿到左边来。
 * 比如数组[1,2,3,3,4]，是有序循环数组，[4,1,2,3,3]也是。
 * 给定数组arr及它的大小n，请返回最小值。
 */

/**
 * 解题思路：二分搜索
 */
public class MinValue {
    public int getMin(int[] arr, int n) {
        // write code here
        int left = 0, right = arr.length - 1;
        int result;
        if (arr[left] < arr[right]) {
            result = arr[left];
            return result;
        }
        int mid = 0;
        //此处不好想
        while (arr[left] >= arr[right]) {
            //当数组只有两个值的时候
            if (right - left == 1)
                return arr[right];
            mid = right + (left - right) / 2;
            //若满足该条件，最小值在[left,mid]范围, 注意right != mid + 1
            if (arr[left] > arr[mid])
                right = mid;
            //若满足该条件，最小值在[mid,right]范围, 注意left != mid -1
            if (arr[right] < arr[mid])
                left = mid;
        }
        return arr[mid];
    }
}
