package BATcourse.Chapter10;

/**
 * 随机函数问题：
 * 给定一个等概率随机产生1~5的随机函数，除此之外，不能使用任何额外的随机机制，请实现等概率随机产生1~7的随机函数。
 * (给定一个可调用的Random5::random()方法,可以等概率地随机产生1～5的随机函数)
 */
import java.util.*;

public class Random7 {
    /*
        解题思路：(1) 根据1-5的随机函数减一，可得到0-4的随机函数f();
                 (2)f() * 5 : 0, 5, 10, 15, 20；
                 (3)f()*5 + f(): 0-24；
                 (4)如果（3）产生的数大于20，则重复执行，直到产生的数在0-20之间；
                 (5)将(4)的结果%7再加1，即为所求；
     */
    private static Random rand = new Random(123456);
    // 随机产生[1,5]
    private int rand5() {
        return 1 + rand.nextInt(5);
    }

    // 通过rand5实现rand7
    public int randomNumber() {
        return rand20()%7 + 1;
    }

    private int f(){
        return rand5()-1;
    }

    private int rand20(){
        int result;
        while(true){
            result = f() * 5 + f();
            if (result <= 20)
                break;
        }
        return result;
    }
}
