package BATcourse.Chapter3;

/**
 * 句子的逆序：
 * 对于一个字符串，请设计一个算法，只在字符串的单词间做逆序调整，也就是说，
 * 字符串由一些由空格分隔的部分组成，你需要将这些部分逆序。
 * 给定一个原字符串A和他的长度，请返回逆序后的字符串。
 */

public class Reverse {
    public String reverseSentence(String A, int n) {
        // write code here
        String[] B = A.split(" ");
        int indexB = B.length - 1;
        String tmp;
        for (int i = 0; i < B.length/2; i++) {
            tmp = B[indexB];
            B[indexB] = B[i];
            B[i] = tmp;
            indexB--;
        }
        String result = "";
        for (int i = 0; i < B.length; i++) {
            if (i == B.length - 1)
                result = result+ B[i];
            else
                result = result+ B[i] + " ";
        }
        return result;
    }
}