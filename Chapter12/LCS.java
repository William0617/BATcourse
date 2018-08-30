package BATcourse.Chapter12;

/**
 * 最长公共子序列:
 * 给定两个字符串A和B，返回两个字符串的最长公共子序列的长度。
 * 例如，A="1A2C3D4B56”，B="B1D23CA45B6A”，”123456"或者"12C4B6"都是最长公共子序列。
 * 给定两个字符串A和B，同时给定两个串的长度n和m，请返回最长公共子序列的长度。保证两串长度均小于等于300。
 */

/**
 * 解题思路：生成M*N的矩阵dp。dp[i][j]表示str1[0…i]与str1[0…j]的最长公共子序列长度。
 */
public class LCS {
    public int findLCS(String A, int n, String B, int m) {
        if (A.length() == 0 || B.length() == 0 || n <= 0 || m <= 0)
            return 0;
        int[][] dp = new int[n][m];
        //处理边界条件
        //第一行：一旦dp[0][j]被置为1，dp[0][j+1]到dp[0][m-1]都置为1；
        for (int j = 0; j < m; j++) {
            String tmp = B.charAt(j) + "";
            String a = A.charAt(0) + "";
            dp[0][j] = (a.equals(tmp) ? 1 : 0);
            if (dp[0][j] == 1) {
                for (int i = j + 1; i < m; i++) {
                    dp[0][i] = 1;
                }
                break;
            }
        }
        //第一列：一旦dp[i][0]被置为1，dp[i+1][0]到dp[n-1][0]都置为1；
        for (int i = 0; i < n; i++) {
            String tmp = A.charAt(i) + "";
            String b = B.charAt(0) + "";
            dp[i][0] = (b.equals(tmp) ? 1 : 0);
            if (dp[i][0] == 1) {
                for (int j = i + 1; j < m; j++) {
                    dp[i][0] = 1;
                }
                break;
            }
        }
        char[] str1 = A.toCharArray();
        char[] str2 = B.toCharArray();
        //dp[i][j]3种情况选最大：（1）dp[i][j] = dp[i-1][j];(2)dp[i][j] = dp[i][j-1];
        // (3)如果str1[i] = str2[j]，那么dp[i][j] = dp[i-1][j-1] + 1；
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (str1[i] == str2[j])
                    dp[i][j] = Max(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]+1);
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[n-1][m-1];
    }

    private int Max(int a, int b, int c) {
        return Math.max(Math.max(a,b),c);
    }

    public static void main(String[] args) {
        LCS lcs = new LCS();
        String a = "rsymsknwbiapzhuoeyhjubogitoqfkswhbqhwqzyjuvdlzjlhlaubecnkzgvurdsuvqghpjazgxvue";
        String b = "sclzdzbtrrkdybusjyjrszzqaebkpdtqnqadndvkenqirqqsplmceuuzhukcxxnkcyyvucqjlkysfarxkulpayvtwfmfaqpikzdslpklomafvtesecxygahwnyljldutzsoywiwkugerfbfefcqfvcrzcvbevufzbkbhfeshhdasqo";
        lcs.findLCS(a,a.length(),b,b.length());
    }
}
