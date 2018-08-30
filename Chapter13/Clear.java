package BATcourse.Chapter13;

public class Clear {
    public int getWinner(int[] A, int n) {
        int[] result = getNumber(A);

        //偶数种数字
        if (result[0] % 2 == 0) {
            //奇数种是奇数个
            if (result[1] % 2 != 0)
                return 1;
            else
                return 0;
        }
        //奇数种数字
        else {
            //
            if (result[2] % 2 == 0)
                return 1;
            else
                return 0;
        }
    }

    private boolean hasEven(int[] count) {
        int num = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] % 2 == 0)
                num++;
        }
        if (num % 2 == 0)
            return true;
        return false;
    }

    private boolean hasOdd(int[] count) {
        int num = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] % 2 != 0)
                num++;
        }
        if (num % 2 == 0)
            return false;
        return true;
    }

    private int[] getNumber(int[] a) {
        int count = 0, odd = 0, even = 0;
        for (int i = 1; i <= a.length; i++) {
            if (isExist(a, i)) {
                count++;
                if (isOdd(a, i))
                    odd++;
                else
                    even++;
            }
        }
        //一共有count种数字。其中，个数为奇数的数字为odd个，个数为偶数的数字为even个
        return new int[]{count,odd,even};
    }

    private boolean isOdd(int[] a, int i) {
        int count = 0;
        for (int j = 0; j < a.length; j++) {
            if (a[j] == i)
                count++;
        }
        if (count % 2 == 0)
            return false;
        return true;
    }

    private boolean isExist(int[] a, int i) {

        for (int j = 0; j < a.length; j++) {
            if (i == a[j])
                return true;
        }
        return false;
    }
}
