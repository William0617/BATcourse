package BATcourse.Chapter12;

/**
 * 动态规划之换零钱问题：
 * 有数组penny，penny中所有的值都为正数且不重复。
 * 每个值代表一种面值的货币，每种面值的货币可以使用任意张，再给定一个整数aim(小于等于1000)代表要找的钱数，
 * 求换钱有多少种方法。
 * 给定数组penny及它的大小(小于等于50)，同时给定一个整数aim，请返回有多少种方法可以凑成aim。
 */

/**
 * 解题思路：
 * 如果arr长度为N，则生成N行，aim+1列的矩阵dp。
 * dp[i][j]表示在使用arr[0…i]货币的情况下，组成钱数j有多少种方法。
 */
public class Exchange {
    public int countWays(int[] arr, int n, int aim) {
        if (arr.length == 0 || n == 0 || aim < 0)
            return 0;
        int[][] dp = new int[n][aim+1];
        //第一列初始化
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }
        //第一行初始化
        for (int i = 0; i < dp[0].length; i++) {
            if (i % arr[0] == 0)
                dp[0][i] = 1;
            else
                dp[0][i] = 0;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                //当前面值比j大的话
                if (arr[i] > j)
                    dp[i][j] = dp[i-1][j];
                else
                    //累加：arr[i-1][j] +(arr[i-1][j-1*arr[i]] +arr[i-1][j-2*arr[i]] + arr[i-1][j-3*arr[i]]...)
                    //括号中的部分等于arr[i][j - 1 * arr[i]]
                    dp[i][j] = dp[i][j-arr[i]]+dp[i-1][j];
            }
        }
        return dp[n-1][aim];
    }

    public static void main(String[] args) {
        Exchange exchange = new Exchange();
        int[] arr = {1,2,4};
        exchange.countWays(arr, 3, 3);
    }
}
