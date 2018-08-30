package BATcourse.Chapter9;

/**
 * 排队买票问题（卡特兰数）:
 * 2n个人排队买票，n个人拿5块钱，n个人拿10块钱，票价是5块钱1张，每个人买一张票，售票员手里没有零钱.
 * 问有多少种排队方法让售票员可以顺利卖票。
 * 给定一个整数n，请返回所求的排队方案个数。保证结果在int范围内。
 */
public class BuyTickets {
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
