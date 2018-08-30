package BATcourse.Chapter8;

/**
 * 比较两个数练习题：(copy)
 * 对于两个32位整数a和b，请设计一个算法返回a和b中较大的。但是不能用任何比较判断。若两数相同，返回任意一个。
 * 给定两个整数a和b，请返回较大的数。
 */

public class Compare {
    public int getMax(int a, int b) {
        // write code here
        int c = a - b;
        int sca = sign(c);
        int scb = flip(sca);
        return sca * a + scb * b;
    }

    public int sign(int n){
        return flip((n >> 31) & 1);
    }
    public int flip(int n){
        return n ^ 1;
    }
}