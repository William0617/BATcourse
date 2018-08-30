package BATcourse.Chapter10;

/**
 * 随机01问题：
 * 给定一个以p概率产生0，以1-p概率产生1的随机函数RandomP::f()，p是固定的值，但你并不知道是多少。
 * 除此之外也不能使用任何额外的随机机制，请用RandomP::f()实现等概率随机产生0和1的随机函数。
 */
import java.util.*;

public class Random01 {
    /**
     * 解题思路：
     * (1)因为产生01和10的概率都是p*(1-p);
     * (2)所以不断调用f()，直到产生01或者10。如果结果为01则返回0，10则返回1。
     */
    private static double p = new Random().nextFloat();
    // 随机概率p
    public static int f() {
        return new Random().nextFloat() < p ? 0 : 1;
    }

    public int random01() {
        // 通过f函数实现01等概率返回
        int[] tmp = new int[2];
        while (true){
            tmp[0] = f();
            tmp[1] = f();
            if (tmp[0] == 0 && tmp[1] == 1)
                return 0;
            if (tmp[0] == 1 && tmp[1] == 0)
                return 1;
        }
    }
}
