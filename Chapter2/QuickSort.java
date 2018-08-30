package BATcourse.Chapter2;
/**
 * 算法思想：
 *　　1）设置两个变量left和right；
 *　　2）把数组最左侧元素设置为基准值，赋值给key，即 key=A[left]；
 *　　3）从后往前搜索，找到比key小的值时，保存他的索引等待；从前往后搜索，找到比key大的值时，保存索引，与之前找到的值交换；
 *　　4）重复第三步，直到首尾两个索引值碰到一起，此时将基准值与两索引指向的值交换；
 * 注意的是，不能直接操作left和right两变量，否则递归会出错。需要先保存在两局部变量中。
 */

public class QuickSort {
    public int[] quickSort(int[] A, int n) {

        quickSort(A, 0, n - 1);
        return A;
    }
    //传入一个数组，和它的边界index；
    public void quickSort(int[] A, int left, int right) {
        //递归结束条件：左边index大于了右边的index；
        if (left >= right)
            return;
        //声明个临时变量，用于交换；
        int tmp;
        //定义一个比较基准值，我采用最左边的值为基准值；
        //注意，要将left和right赋值给局部变量，以下对该局部变量进行操作，不改变原来的值；
        int key = A[left], first = left , last = right;
        //当两个指针相遇，本趟结束
        while (last != first) {
            //注意顺序，要从后往前开始找到一个小于基准值的数的index
            for (int j = last; j >= first; j--) {
                if (A[j] < key) {
                    //找到一个小于基准值的数的index，跳出循环，等待first指针；
                    last = j;
                    break;
                }
                //如果一直找，等到和first相等时，把基准值与这个值进行交换，并更新last（此时与first的index相同）
                if (j == first) {
                    tmp = A[left];
                    A[left] = A[j];
                    A[j] = tmp;
                    last = j;
                    break;
                }
            }
            //从前往后开始找到一个大于基准值的数的index
            for (int i = first; first <= last; i++) {
                if (A[i] > key) {
                    //找到一个大于基准值的数的index，跳出循环，与之前找到的last指向的值进行交换；
                    first = i;
                    break;
                }
                //如果一直找，等到和last相等时，把基准值与这个值进行交换，并更新first（此时与first的index相同）
                if (i == last) {
                    tmp = A[left];
                    A[left] = A[i];
                    A[i] = tmp;
                    first = i;
                    break;
                }
            }
            //讲两个循环中找到的合适的index的值交换
            if (A[first] > key && A[last] < key){
                tmp = A[first];
                A[first] = A[last];
                A[last] = tmp;
            }
        }
        //递归排序左边，first动态更新，一直等于基准值的index
        quickSort(A, left, first - 1);
        //下面first值为上面变换过的值，不是第一次值！！！值怎么取？？？？？
        //设置两个变量存left和right
        //递归排序右边
        quickSort(A, first + 1 , right);
    }
}
