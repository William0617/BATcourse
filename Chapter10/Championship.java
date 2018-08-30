package BATcourse.Chapter10;

/**
 * 足球比赛：
 * 有2k只球队，有k-1个强队，其余都是弱队，随机把它们分成k组比赛，每组两个队，问两强相遇的概率是多大？
 * 给定一个数k，请返回一个数组，其中有两个元素，分别为最终结果的分子和分母，请化成最简分数.
 */

/*  解题思路：
            （1）求总数：因为有k组，所以第一组有2k-1种，第二组有2k-3种...第i组有2k-(2i - 1)种；相乘即为总方法数；
            （2）求没有两强相遇的种数：从k+1个弱队中选出k-1个队伍与强队配对：C（k-1）(k+1) * A(k-1)(k-1)
             (3)(1)与(2)差值除以总数即为所求；
 */
public class Championship {
    public int[] calc(int k) {
        if (k == 0)
            return null;
        int sum = 1;
        int[] result = new int[2];
        result[0] = 0;
        result[1] = 1;
        if (k == 2)
            return result;
        for (int i = 1; i <= k; i++) {
            sum = sum * (2 * k - (2 * i - 1));
        }
        int C, A = 1, copy = k + 1, up = 1, down = 1;
        for (int i = 1; i <= k - 1; i++) {
            down = down * i;
            up = up * copy;
            A = A * i;
            copy--;
        }
        C = up / down;
        int weakAndStrong = A * C;
        result[0] = sum - weakAndStrong;
        result[1] = sum;
        if (result[0] == 0 || result[1] == 0) {
            return result;
        }
        int gcd = gcd(result[1], result[0]);
        result[0] = result[0] / gcd;
        result[1] = result[1] / gcd;
        return result;
    }

    public int gcd(int m, int n) {
        if (m % n == 0) {
            return n;
        } else {
            return gcd(n, m % n);
        }
    }
}
