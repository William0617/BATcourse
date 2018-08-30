package BATcourse.Chapter9;

/**
 * 高矮排列练习：
 * 12个高矮不同的人，排成两排，每排必须是从矮到高排列，而且第二排比对应的第一排的人高，问排列方式有多少种？
 * 给定一个偶数n，请返回所求的排列方式个数。保证结果在int范围内。
 */

public class HighAndShort {
    public int countWays(int n) {
        n = n / 2;
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
