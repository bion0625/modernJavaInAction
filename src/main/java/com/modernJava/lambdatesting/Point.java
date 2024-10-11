package com.modernJava.lambdatesting;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Point {
    public final static Comparator<Point> compareXAndThenY =
            Comparator.comparing(Point::getX).thenComparing(Point::getY);
    public static List<Point> moveAllPointsRightBy(List<Point> points, int x) {
        return points.stream()
                .map(p -> new Point(p.getX() + x, p.getY()))
                .collect(Collectors.toList());
    }
    private final int x;
    private final int y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int getX() { return this.x; }
    public int getY() { return this.y; }
    public Point moveRightBy(int x) {
        return new Point(this.x + x, this.y);
    }

    @Override
    public boolean equals(Object obj) {
        Point point = (Point) obj;
        return point != null
                && this.getX() == point.getX()
                && this.getY() == point.getY();
    }
}
