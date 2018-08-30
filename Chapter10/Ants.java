package BATcourse.Chapter10;

/**
 * 蚂蚁问题：
 * n只蚂蚁从正n边形的n个定点沿着边移动，速度是相同的，问它们碰头的概率是多少？
 * 给定一个正整数n，请返回一个数组，其中两个元素分别为结果的分子和分母，请化为最简分数.
 */
public class Ants {
    /*
          解题思路：
                  （1）每只蚂蚁有顺时针、逆时针两种方向，所以共有2的n次方种走法；
                  （2）只有2种情况，即大家全部顺时针/逆时针的情况不会相遇；
                  （3）总数-不相遇概率即为所求；
     */
    public int[] collision(int n) {
        // write code here
        if (n == 0 || n == 1)
            return null;
        int[] result = new int[2];
        int total = (int)Math.pow(2, n);
        int gcd = gcd(total, total - 2);
        result[0] = (total - 2) / gcd;
        result[1] = total / gcd;
        return result;
    }

    private int gcd(int total, int i) {
        if (total % i == 0)
            return i;
        return gcd(i, total%i);
    }
}
