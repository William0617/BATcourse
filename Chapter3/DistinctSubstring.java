package BATcourse.Chapter3;

/**
 * 最长无重复字符字串：
 * 对于一个字符串,请设计一个高效算法，找到字符串的最长无重复字符的子串长度。
 * 给定一个字符串A及它的长度n，请返回它的最长无重复字符子串长度。保证A中字符全部为小写英文字符，且长度小于等于500。
 */
import java.util.*;
/*解题思路：
        求出以string中每个字符结尾的情况下，最长无重复字符子串的长度，并在其中找出最大值返回；
 */
public class DistinctSubstring {
    public int longestSubstring(String A, int n) {
        char[] array = A.toCharArray();
        //存放每种字符之前出现的位置
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        //以s[i-1]结尾情况下，最长无重复子串的长度
        int pre = 0, max = pre;
        for (int i = 0; i < n; i++) {
            if (map.get(array[i])==null){
                map.put(array[i], i);
                pre++;
                if (pre > max)
                    max = pre;
                continue;
            }
            //根据老师图所示，为求index，所以要+1；
            int posA = map.get(array[i]) + 1;
            //pre是s[i-1]时候最长串的长度！我们要求index值！！
            int posB = (i - 1) - pre + 1;
            if(posA > posB){
                map.put(array[i], i);
                pre = i - posA + 1;
            }
            else{
                map.put(array[i], i);
                pre = i - posB + 1;
            }
            if (pre > max)
                max = pre;
        }
        return max;
    }
}