package BATcourse.Chapter12;

/**
 * 台阶问题：
 * 有n级台阶，一个人每次上一级或者两级，问有多少种走完n级台阶的方法。为了防止溢出，请将结果Mod 1000000007
 * 给定一个正整数int n，请返回一个数，代表上楼的方式数。保证n小于等于100000。
 */

/**
 * 解题思路：
 * 1. n = 1: f(1) = 1;
 * 2. n = 2: f(2) = 2;
 * 3. n > 2: f(n) = f(n-1)+f(n-2);
 */
public class GoUpstairs {

    public static final int MOD = 1000000007;

    //动态规划
    public int countWays(int n) {
        if (n <= 0)
            return 0;
        if (n == 1 || n == 2)
            return n;
        //初始化。first=1表示n为1时有一种方法；second=2表示n为2时，有两种方法；
        int first = 1, second = 2, res = 0;
        //i表示台阶数量
        for (int i = 3; i <= n; i++) {
            //f(i) = f(i-1)+f(i-2);
            res = (first + second) % MOD;
            //更新f(i-1)和f(i-2)
            first = second;
            second = res;
        }
        return res;
    }

    //暴力方法
    public int countWays1(int n) {
        if (n < 0)
            return 0;
        if (n == 1 || n == 2)
            return n;
        return (countWays1(n - 1) + countWays1(n - 2)) % 1000000007;
    }
}
