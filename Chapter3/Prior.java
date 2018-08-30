package BATcourse.Chapter3;

import java.util.*;

/**
 * 拼接最小字典序：
 * 对于一个给定的字符串数组，请找到一种拼接顺序，使所有小字符串拼接成的大字符串是所有可能的拼接中字典序最小的。
 * 给定一个字符串数组strs，同时给定它的大小，请返回拼接成的串。
 */
public class Prior {
    //若顺序str1 + str2 > str2 + str1, 则str1放前面
    public String findSmallest(String[] strs, int n) {
        // write code here
        if (strs == null || n == 0) {
            return "";
        }
        // 根据新的比较方式排序
        Arrays.sort(strs, new MyComparator());
        String result = "";
        for (int i = 0; i < n; i++) {
            result += strs[i];
        }
        return result;
    }
}
//排序规则
class MyComparator implements Comparator<String> {

    @Override
    public int compare(String s1, String s2) {
        return (s1 + s2).compareTo(s2 + s1);
    }
}