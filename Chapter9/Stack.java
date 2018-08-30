package BATcourse.Chapter9;

/**
 * 进出站问题（算法与括号序列问题一致）：
 * n个数进出栈的顺序有多少种？假设栈的容量无限大。
 * 给定一个整数n，请返回所求的进出栈顺序个数。保证结果在int范围内。
 */

public class Stack {
    public int countWays(int n) {
        int up = 1, down = 1, copy = 2*n;
        for (int i = 1; i <= n; i++) {
            down = down * i;
            up = up * copy;
            if (up % down == 0){
                up = up / down;
                down = 1;
            }
            copy--;
        }
        return up / down / (n + 1);
    }
}
