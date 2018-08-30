package BATcourse.Chapter3;

/**
 * 空格替换：
 * 请编写一个方法，将字符串中的空格全部替换为“%20”。
 * 假定该字符串有足够的空间存放新增的字符，并且知道字符串的真实长度(小于等于1000)，
 * 同时保证字符串由大小写的英文字母组成。
 * 给定一个string iniString 为原始的串，以及串的长度 int len, 返回替换后的string。
 */

//解题思路：先计算出字符串中有几个空格，那么就可以知道新的串多长了；
//          然后从老字符串最后一个开始向前遍历，遇到非空格就复制到新串里；遇到空格就依次把% 2 0三个字符复制到新串里；
public class Replacement {
    public String replaceSpace(String iniString, int length) {
        // write code here
        char[] arrays = iniString.toCharArray();
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (arrays[i] == ' ')
                count++;
        }
        int last = length + 2 * count;
        int oldIndex = length-1;
        int newIndex = last-1;
        char[] newArray = new char[last];
        for (int i = 0; i < arrays.length; i++) {
            newArray[i] = arrays[i];
        }
        while (newIndex - 2 >=0 && oldIndex >=0){
            if (newArray[oldIndex] != ' '){
                newArray[newIndex] = newArray[oldIndex];
                newIndex--;
            }
            else {
                newArray[newIndex] = '0';
                newArray[newIndex-1]='2';
                newArray[newIndex-2]='%';
                newIndex-=3;
            }
            oldIndex--;
        }
        return String.valueOf(newArray);
    }
}