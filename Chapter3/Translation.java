package BATcourse.Chapter3;

/**
 * 字符串移位：
 * 对于一个字符串，请设计一个算法，将字符串的长度为len的前缀平移到字符串的最后。
 * 给定一个字符串A和它的长度，同时给定len，请返回平移后的字符串。空间复杂度为O（1），时间复杂度为O（n）.
 */
public class Translation {
    /*
       解题思路：（1）将0-i部分字符逆序；（2）将i+1到N-1字符逆序；（3）将整个字符串逆序
     */
    public String stringTranslation(String A, int n, int len) {
        // write code here
        char[] a = A.toCharArray();
        reverse(a, 0, len-1);
        reverse(a, len, n-1);
        reverse(a, 0, n-1);
        return String.valueOf(a);//char数组转换为String函数
    }

    private void reverse(char[] a, int start, int end) {
        while (start <= end){
            swap(a, start++, end--);
        }
    }

    private void swap(char[] a, int start, int end) {
        char tmp;
        tmp = a[start];
        a[start] = a[end];
        a[end] = tmp;
    }

}
