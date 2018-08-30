package BATcourse.Chapter8;

/**
 * 寻找奇数出现2：
 * 给定一个整型数组arr，其中有两个数出现了奇数次，其他的数都出现了偶数次，找到这两个数。要求时间复杂度为O(N)，额外空间复杂度为O(1)。
 * 给定一个整形数组arr及它的大小n，请返回一个数组，其中两个元素为两个出现了奇数次的元素,请将他们按从小到大排列。
 */
import java.util.*;

/**
 * 解题思路：
 * 1. 将一个变量tmp与所有的数字异或，结果就是两个奇数的的异或结果tmp=a^b；
 * 2. 找到tmp不为0的第K位，说明该位a与b不同；
 * 3. 遍历数组，用新变量tmp2与第K位为1的数进行异或运算，其结果就是a或者b的一个；
 * 4. 用tmp于tmp2异或，得到另一个；
 */
public class OddAppearance2 {

    public int[] findOdds(int[] arr, int n) {
        int tmp = 0;
        for (int i = 0; i < arr.length; i++) {
            tmp = arr[i] ^ tmp;
        }

        int a = tmp, index = 0;
        for (int i = 0; i < 32; i++) {
            int b = (a >> i) & 1;
            if (b == 1) {
                index = i;
                break;
            }
        }

        int tmp2 = 0;
        for (int i = 0; i < arr.length; i++) {
            if (((arr[i] >> index)& 1) == 1)
                tmp2 = tmp2 ^ arr[i];
        }
        int[] result = new int[2];
        result[0] = tmp2 ^ tmp;
        result[1] = tmp2;
        Arrays.sort(result);
        return result;
    }
}
