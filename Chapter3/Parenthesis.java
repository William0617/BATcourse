package BATcourse.Chapter3;

/**
 * 合法括号序列判断：
 * 对于一个字符串，请设计一个算法，判断其是否为一个合法的括号串。
 * 给定一个字符串A和它的长度n，请返回一个bool值代表它是否为一个合法的括号串。
 */

/*
       解题思路：1. num代表左右括号出现次数的差值；
                2. 遍历过程中，遇到左括号num++; 遇到右括号num—；
                3. 如果某一时刻num<0，则直接返回false；
                4. 遍历完毕，num==0则true；
 */
public class Parenthesis {
    public boolean chkParenthesis(String A, int n) {
        // write code here
        int num = 0;
        for(int i = 0; i < A.length(); i++){
            if(num < 0)
                return false;
            if(A.charAt(i) == '(')
                num++;
            if(A.charAt(i) == ')')
                num--;
        }
        if(num == 0)
            return true;
        return false;
    }
}
