package BATcourse.Chapter12;

/**
 * 最优编辑：
 * 对于两个字符串A和B，我们需要进行插入、删除和修改操作将A串变为B串，定义c0，c1，c2分别为三种操作的代价，
 * 请设计一个高效算法，求出将A串变为B串所需要的最少代价。
 * 给定两个字符串A和B，及它们的长度和三种操作代价，请返回将A串变为B串所需要的最小代价。
 * 保证两串长度均小于等于300，且三种代价值均小于等于100。
 */

/**
 * 解题思路：dp[i][j]表示使用a的前i-1个字符，得到b的前j-1个字符的最小代价；
 */
public class MinCost {
    public int findMinCost(String a, int n, String b, int m, int ic, int dc, int rc) {
        if (a.length() == 0 || b.length() == 0 || n == 0 || m == 0)
            return 0;
        if (a.equals(b))
            return 0;
        //多出一行一列的空字符
        int[][] dp = new int[n + 1][m + 1];
        //初始化第一行：都是插入代价
        dp[0][0] = 0;
        for (int j = 1; j < dp.length; j++) {
            dp[0][j] = ic * j;
        }
        //初始化第一列：都是删除代价
        for (int i = 1; i < m + 1; i++) {
            //根据题意，不能用空字符串替换字符
            dp[i][0] = dc * i;
        }
        //求dp[i][j]
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                //四种情况
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j] + dc, dp[i][j - 1] + ic));
                }
                else
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + rc, Math.min(dp[i - 1][j] + dc, dp[i][j - 1] + ic));
            }
        }
        return dp[n][m];
    }


    public static void main(String[] args) {
        MinCost minCost = new MinCost();
        String a = "abc";
        String b = "adc";

        minCost.findMinCost(a, a.length(), b, b.length(), 5, 3, 100);
    }
}
