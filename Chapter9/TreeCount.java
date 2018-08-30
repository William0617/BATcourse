package BATcourse.Chapter9;

/**
 * 二叉树统计(卡特兰数)：
 * 求n个无差别的节点构成的二叉树有多少种不同的结构？
 * 给定一个整数n，请返回不同结构的二叉树的个数。保证结果在int范围内。
 */

//1，1，2，5，
public class TreeCount {
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