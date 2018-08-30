package BATcourse.Chapter6;

/**
 * 快速N次方练习：
 * 如果更快的求一个整数k的n次方。
 * 如果两个整数相乘并得到结果的时间复杂度为O(1)，得到整数k的N次方的过程请实现时间复杂度为O(logN)的方法。
 * 给定k和n，请返回k的n次方，为了防止溢出，请返回结果Mod 1000000007的值。
 */
        import java.math.BigInteger;

/**
 * 解题思路：用n的二进制形式。
 */
public class QuickPower {
    public int getPower(int k, int N) {
        BigInteger result = new BigInteger("1");
        BigInteger mod = new BigInteger("1000000007");
        BigInteger oneStep = new BigInteger(""+1);
        BigInteger K = new BigInteger(""+k);
        int flag = 1;
        while (N != 0){
            int tmp = (N & 1);
            BigInteger tmp1 = new BigInteger(tmp+"");
            if (flag++ == 1) {
                oneStep = oneStep.multiply(K);
            }
            else
                oneStep = oneStep.multiply(oneStep).mod(mod);
            if (tmp != 0){
                result = result.multiply(tmp1).multiply(oneStep).mod(mod);
            }
            N = N >> 1;
        }
        return result.mod(mod).intValue();
    }

    public static void main(String[] args) {
        QuickPower quickPower = new QuickPower();
        System.out.println(quickPower.getPower(2, 3));
    }
}
