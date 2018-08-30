package BATcourse.Chapter2;

import java.util.*;

/**
 * 数组排序之后，相邻两数最大差值：
 * 有一个整形数组A，请设计一个复杂度为O(n)的算法，算出排序后相邻两数的最大差值。
 * 给定一个int数组A和A的大小n，请返回最大的差值。保证数组元素多于1个。
 */
public class Gap {
    public int maxGap(int[] A, int n) {
        //1. 遍历数组，找出最小值与最大值
        int max = A[0], min = A[0];
        for (int i = 0; i < A.length; i++) {
            if (A[i] > max)
                max = A[i];
            if (A[i] < min)
                min = A[i];
        }
        //2. 把[min, max）范围等量地分配n个区间；每个数进入桶中，最大值放入n+1号桶
        Bucket[] buckets = new Bucket[n + 1];
        for (int i = 0; i < n + 1; i++) {
            Bucket bucket = new Bucket();
            buckets[i] = bucket;
        }
        double difference = ((double) max - (double) min) / n;

        int count;
        double num;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == max) {
                buckets[n].add(max);
                ++i;
            }
            //对判断指针修改后要进行判断
            if (i >= n)
                break;
            num = min;
            count = -1;
            while (A[i] >= num) {
                num = num + difference;
                count++;
            }
            buckets[count].add(A[i]);
        }
        //比较??
        int gap = 0, bucketDifference;
        int i = n, j = n - 1;
        while (j >= 0 && i >= 0) {
            while (buckets[i].isEmpty())
                i--;
            while (buckets[j].isEmpty())
                j--;

            if (j >= 0 && i >= 0 && !buckets[i].isEmpty() && !buckets[j].isEmpty()) {
                bucketDifference = buckets[i].getMinElement() - buckets[j].getMaxElement();
                if (bucketDifference > gap)
                    gap = bucketDifference;
            }
            i--;
            j--;
        }
        return gap;
    }

    class Bucket {
        public List<Integer> list = new ArrayList<Integer>();
        private int maxElement;

        public void add(int element) {
            this.list.add(element);
        }

        public int getMinElement() {
            int min = list.get(0);
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) < min)
                    min = list.get(i);

            }
            return min;
        }

        public boolean isEmpty() {
            return list.size() == 0;
        }

        public int getMaxElement() {
            int max = list.get(0);
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) > max)
                    max = list.get(i);

            }
            return max;
        }
    }
}
