package BATcourse.Chapter8;

/**
 * 寻找奇数出现：
 * 有一个整型数组A，其中只有一个数出现了奇数次，其他的数都出现了偶数次，请打印这个数。要求时间复杂度为O(N)，额外空间复杂度为O(1)。
 * 给定整形数组A及它的大小n，请返回题目所求数字。
 * tips:n与0异或结果为n；n与n异或结果为0；
 */

/**
 * 解题思路：
 * 设置一个tmp与数组中每个数异或，最后的值就是所求；
 */
public class OddAppearance {
    public int findOdd(int[] A, int n) {
        // write code here
        int tmp = 0;
        for (int i = 0; i < A.length; i++) {
            tmp= tmp ^ A[i];
        }
        return tmp;
    }
}
