package BATcourse.Chapter12;

/**
 * 矩阵最小路径练习题：
 * 有一个矩阵map，它每个格子有一个权值。从左上角的格子开始每次只能向右或者向下走，
 * 最后到达右下角的位置，路径上所有的数字累加起来就是路径和，返回所有的路径中最小的路径和。
 * 给定一个矩阵map及它的行数n和列数m，请返回最小路径和。保证行列数均小于等于100.
 */

/**
 * 解题思路：
 */
public class MinimumPath {
    public int getMin(int[][] map, int n, int m) {
        // write code here
        if (n <= 0 || m <= 0)
            return 0;
        //dp[i][j]表示从map[0][0]走到map[i][j]的最小值
        int[][] dp = new int[n][m];
        //初始化第一行，累加
        int sum = map[0][0];
        for (int i = 0; i < m; i++) {
            dp[0][i] = sum;
            if (i + 1 < m)
                sum = sum + map[0][i + 1];
        }
        //初始化第一列，累加
        sum = map[0][0];
        for (int i = 0; i < n; i++) {
            dp[i][0] = sum;
            if (i + 1 < n)
                sum = sum + map[i + 1][0];
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                //到达map[i][j]的最小值只能来自他的上方或者左侧；
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + map[i][j];
            }
        }
        return dp[n - 1][m - 1];
    }
}
