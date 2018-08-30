package BATcourse.Chapter2;

/**
 * 有序矩阵查找练习题：
 * 现在有一个行和列都排好序的矩阵，请设计一个高效算法，快速查找矩阵中是否含有值x。
 * 给定一个int矩阵mat，同时给定矩阵大小nxm及待查找的数x，请返回一个bool值，代表矩阵中是否存在x。
 * 所有矩阵中数字及x均为int范围内整数。保证n和m均小于等于1000
 */
public class Finder {
    public boolean findX(int[][] mat, int n, int m, int x) {
        // write code here
        int currentRow = 0;
        int currentColumn = m - 1;
        while (currentRow < n && currentColumn >= 0){
            if (x > mat[currentRow][currentColumn])
                currentRow++;
            if (currentRow < n && x < mat[currentRow][currentColumn])
                currentColumn--;
            if (currentRow < n && currentColumn >= 0 && x == mat[currentRow][currentColumn])
                return true;
        }
        return false;
    }
}
