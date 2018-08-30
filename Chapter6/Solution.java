package BATcourse.Chapter6;

/**
 * 局部最小值位置练习：
 * 定义局部最小的概念。arr长度为1时，arr[0]是局部最小。
 * arr的长度为N(N>1)时，如果arr[0]<arr[1]，那么arr[0]是局部最小；
 * 如果arr[N-1]<arr[N-2]，那么arr[N-1]是局部最小；
 * 如果0<i<N-1，既有arr[i]<arr[i-1]又有arr[i]<arr[i+1]，那么arr[i]是局部最小。
 * 给定无序数组arr，已知arr中任意两个相邻的数都不相等，写一个函数，只需返回arr中任意一个局部最小出现的位置即可。
 */

/**
 * 解题思路：
 * 如果arr长度大于1，先检查数组两头的位置。
 */
public class Solution {
    public int getLessIndex(int[] arr) {
        //特殊边界
        if (arr.length == 0)
            return -1;
        if (arr.length == 1)
            return 0;
        //如果arr长度大于1，先检查数组两头的位置
        if (arr[0] < arr[1])
            return 0;
        if (arr[arr.length - 1] < arr[arr.length - 2])
            return arr.length - 1;
        //二分搜索
        int left = 1, right = arr.length - 2;
        //自己在最开始参数判定的时候 已经考虑了0和n-1  所以在写程序的时候应该是1到n-2!! 我的天排错排了一下午
        while (left <= right) {
            int mid = right+ (left - right) / 2;
            if (arr[mid] > arr[mid - 1] && arr[mid] < arr[mid + 1])
                right = mid - 1;
            if (arr[mid] > arr[mid + 1] && arr[mid] < arr[mid - 1] )
                left = mid + 1;
            if (arr[mid] < arr[mid - 1] && arr[mid] < arr[mid + 1])
                return mid;
            //arr[mid]比左右都大，说明左右两边都存在局部最小值，从哪边搜索都可以
            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1])
                right = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {10,5,10,5,0,1,2,4,7,3,2,9,5,4,6,5,10,6,7,10,9,4,3,7,2,9,5,4,6,10};
        Solution solution = new Solution();
        System.out.println(solution.getLessIndex(a));
    }
}