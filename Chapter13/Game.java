package BATcourse.Chapter13;

/**
 * A与B做游戏。 在一个n*m的矩阵中的出发点是（1，m），终点是（n,1）。
 * 规则是只能向左移动一格，向下一格或向左下移动一格，先走到终点的为winner。
 * A先走。给定两个整数n和m，请返回最后的获胜者的名字(A或B)。
 */

/*
        通过枚举可知，有三种情况：
        （1）只有一行或者一列时，A先走，肯定A胜利；
        （2）除去（1）中情况，m*n为奇数时，B获胜；
        （3）m*n为偶数时，A获胜；
*/
public class Game {
    public char getWinner(int n, int m) {

        if(n == 1 || m == 1)
            return 'A';
        if(m*n % 2 == 0)
            return 'A';
        else
            return 'B';
    }
}
