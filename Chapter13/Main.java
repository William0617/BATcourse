package BATcourse.Chapter13;

import java.util.*;
public class Main {
    static final Point START = new Point(0,0);
    static int minPath = Integer.MAX_VALUE;

/** 请完成下面这个函数，实现题目要求的功能 **/
    /** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^  **/
    static int calculate(Point start, Point[] points, int sum, int count) {
        if(count == points.length){
            minPath = Math.min(minPath, sum +start.getLength(START));
            return minPath;
        }
        for (Point point : points) {
            if (!point.accessible) {
                sum += point.getLength(start);
                if (sum < minPath) {
                    point.accessible = true;
                    calculate(point, points, sum, count + 1);
                }
                sum -= point.getLength(start);
                point.accessible = false;
            }
        }
        return minPath;
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine().trim());
        int index = 0;
        Point[] points = new Point[num];
        while(num-- > 0){
            String[] locations = scanner.nextLine().trim().split(",");
            points[index++] = new Point(Integer.parseInt(locations[0]), Integer.parseInt(locations[1]));
        }

        int min = calculate(START, points, 0, 0);
        System.out.println(min);
    }
}
class Point{
    int x;
    int y;
    boolean accessible;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
        this.accessible = false;
    }

    public int getLength(Point p){
        return Math.abs(x - p.x) + Math.abs(y - p.y);
    }
}