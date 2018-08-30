package BATcourse.Chapter13;

/**
 * 赛马问题：
 * 作为一个马场的主人，你要安排你的n匹赛马和另一个马场的n匹马比赛。
 * 你已经知道了对方马场的出战表，即参加每一场的马的强壮程度。
 * 当然你也知道你自己的所有马的强壮程度。
 * 我们假定比赛的结果直接由马的强壮程度决定，即更壮的马获胜(若相同则双方均不算获胜)。
 * 请你设计一个策略，使你能获得尽量多的场次的胜利。
 * 给定对方每场比赛的马的强壮程度oppo及你的所有马的强壮程度horses(强壮程度为整数，且数字越大越强壮)同时给定n，
 * 请返回最多能获胜的场次。
 */
import java.util.*;

public class HorseRace {
    public int winMost(int[] oppo, int[] horses, int n) {
        if (n == 0)
            return 0;
        //对两个数组进行排列，然后从尾到头遍历
        Arrays.sort(oppo);
        Arrays.sort(horses);
        int my = n-1, he = n-1, count = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (my < 0 || he <0)
                break;
            if (horses[my] > oppo[he]) {
                count++;
                my--;
                he--;
            }
            if (my < 0 || he <0)
                break;
            if (horses[my] <= oppo[he]){
                he--;
            }
        }
        return count;
    }
}