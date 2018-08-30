package BATcourse.Chapter9;

/**
 * 括号序列问题：
 * 假设有n对左右括号，请求出合法的排列有多少个？合法是指每一个括号都可以找到与之配对的括号。
 * 比如n=1时，()是合法的，但是)(为不合法。
 * 给定一个整数n，请返回所求的合法排列数。保证结果在int范围内。
 */

/*
    解题思路：
        当左括右号数量都为n，总排列数为Cn 2n, 不合法排列数为Cn+1 2n。
        他们的差可化简为：Cn 2n / (n+1)；叫做卡特兰数。
 */
public class Parenthesis {
    public int colWays(int n) {
        int illegal, total;
        int up = 1, down = 1, copyN = 2 * n, copy = 2 * n;
        for (int i = 1; i <= n + 1; i++) {
            down = down * i;
            up = up * copyN;
            //及时约分，否则会溢出
            if (up % down == 0) {
                up = up / down;
                down = 1;
            }
            copyN--;
        }
        illegal = up / down;
        int left = 1, right = 1;
        for (int i = 1; i <= n; i++) {
            right = right * i;
            left = left * copy;
            if (left % right == 0) {
                left = left / right;
                right = 1;
            }
            copy--;
        }
        total = left / right;
        return total - illegal;
    }
}
