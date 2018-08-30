package BATcourse.Chapter6;

/**
 * 最左元位：
 * 有一个有序数组arr，其中不含有重复元素，请找到满足arr[i]==i条件的最左的位置。
 * 如果所有位置上的数都不满足条件，返回-1。
 * 给定有序数组arr及它的大小n，请返回所求值。
 */

/**
 * 解题思路：
 * 1. 如果arr[0] > n-1，则不存在；
 * 2. 如果arr[n-1] < 0，则不存在；
 * 3. 如果不是1-2，则考虑中间位置的数M：
 *  3.1如果arr[m] > m，在[0,m-1]中找；
 *  3.2如果arr[m] < m，在[m+1,n-1]中找；
 */
public class Find {
    public int findPos(int[] arr, int n) {
        int result = -1;
        if (n == 0)
            return result;
        if (n == 1)
            return arr[0];

        if (arr[0] > n-1)
            return result;
        if (arr[n-1] < 0)
            return result;
        int left = 0, right = n - 1, mid;
        //循环何时结束？？？必须有等号。
        while (left <= right){
            mid = right + (left - right) / 2;
            if (arr[mid] > mid)
                right = mid - 1;
            if (arr[mid] < mid)
                left = mid + 1;
            if (arr[mid] == mid) {
                result = mid;
                right = mid - 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Find find = new Find();
        int[] a = {-1, 0, 2,3};
        System.out.println(find.findPos(a, a.length));
    }
}
