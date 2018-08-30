package BATcourse.Chapter12;

/**
 * 01背包问题：
 * 一个背包有一定的承重cap，有N件物品，每件都有自己的价值，记录在数组v中，
 * 也都有自己的重量，记录在数组w中，每件物品只能选择要装入背包还是不装入背包，
 * 要求在不超过背包承重的前提下，选出物品的总价值最大。
 * 给定物品的重量w价值v及物品数n和承重cap。请返回最大总价值。
 */

/**
 * 解题思路：dp[i][j]表示前i件物品，达到重量不超过j的最大 价值；
 * 1. 如果选择了第i件物品，那么前i-1件重量不超过j-w[i]；
 * 2. 如果不选择第i件物品，则前i-1件重量不超过j;
 * 所以dp[i][j]可能等于dp[i-1][j]；也可能等于d[i-1][j-w[i]]+v[i].
 * 选择值最大的作为结果。
 */
public class Backpack {
    public int maxValue(int[] w, int[] v, int n, int cap) {
        if (w.length == 0 || v.length == 0 || n == 0 || cap == 0)
            return 0;
        //注意，背包重量可以与cap相等！
        int[][] dp = new int[n][cap + 1];
        //初始化第一行：达到j重量的第一件物品的价值；
        for (int j = 0; j <= cap; j++) {
            //01背包问题，只能装或者不装
            if (j >= w[0])
                dp[0][j] = v[0];
        }
        //初始化第一列：重量为0的任何物品价值都是0；
        for (int i = 0; i < n; i++) {
            dp[i][0] = 0;
        }
        //求dp[i][j]
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (j < w[i])
                    dp[i][j] = dp[i - 1][j];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i]] + v[i]);
            }
        }
        return dp[n - 1][cap];
    }

    public static void main(String[] args) {
        Backpack backpack = new Backpack();
        int[] a = {42, 25, 30, 35, 42, 21, 26, 28};
        int[] b = {261, 247, 419, 133, 391, 456, 374, 591};
        backpack.maxValue(a, b, 8, 297);
    }
}
