package BATcourse.Chapter3;
/**
 * 判断变形词：
 * 对于两个字符串A和B，如果A和B中出现的字符种类相同且每种字符出现的次数相同，
 * 则A和B互为变形词，请设计一个高效算法，检查两给定串是否互为变形词。
 * 给定两个字符串A和B及他们的长度，请返回一个bool值，代表他们是否互为变形词。
 */

        import java.util.*;

public class Transform {
    public boolean chkTransform(String A, int lena, String B, int lenb) {
        // write code here
        Map<Character, Integer> mapA = new HashMap<Character, Integer>();
        Map<Character, Integer> mapB = new HashMap<Character, Integer>();
        char[] a = A.toCharArray();
        char[] b = B.toCharArray();
        for (int i = 0; i < a.length; i++) {
            if (mapA.containsKey(a[i])){
                int value = mapA.get(a[i]) + 1;
                mapA.put(a[i], value);
            }
            mapA.put(a[i], 1);
        }
        for (int i = 0; i < b.length; i++) {
            if (mapB.containsKey(b[i])){
                int value = mapB.get(b[i]) + 1;
                mapB.put(b[i], value);
            }
            mapB.put(b[i], 1);
        }
        return mapA.equals(mapB);
    }
}