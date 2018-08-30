package BATcourse.Chapter6;

/**
 * 元素最左出现练习题：
 * 对于一个有序数组arr，再给定一个整数num，请在arr中找到num这个数出现的最左边的位置。
 * 给定一个数组arr及它的大小n，同时给定num。请返回所求位置。若该元素在数组中未出现，请返回-1。
 */

/**
 * 解题思路：二分搜索一直进行下去直到找到最左边的位置。
 */
public class LeftMostAppearance {
    public int findPos(int[] arr, int n, int num) {
        int result = -1;
        int left = 0, right = n - 1, mid = right+ (left -right) / 2;
        while (left <= right){
            mid = right+ (left -right) / 2;
            if (arr[mid] > num)
                right = mid - 1;
            if (arr[mid] < num)
                left = mid + 1;
            if (arr[mid] == num) {
                result = mid;
                right = mid - 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LeftMostAppearance tmp = new LeftMostAppearance();
        System.out.println(tmp.findPos(new int[]{1,2,3,3,4}, 5, 3));
    }
}
