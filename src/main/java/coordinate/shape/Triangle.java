package coordinate.shape;

import coordinate.point.Point;
import coordinate.point.Points;

public class Triangle extends Shape implements Computable {
    public Triangle(Points points) {
        super(points);
        validate();
    }

    @Override
    public double compute() {
        double x = this.getDistance(0, 1);
        double y = this.getDistance(0, 2);
        double z = this.getDistance(1, 2);
        double s = (x + y + z) / 2;
        return Math.sqrt(s * (s-x) * (s-y) * (s-z));
    }

    private void validate() {
        Points points = this.getPoints();
        boolean sameLine = isSameLine(points.getSpecificPoint(0), points.getSpecificPoint(1), points.getSpecificPoint(2));
        if(sameLine) {
            throw new IllegalArgumentException("같은 라인입니다.");
        }
    }

    private boolean isSameLine(Point p1, Point p2, Point p3) {
        int firstLineX = Math.abs(p1.getX() - p2.getX());
        int secondLineX = Math.abs(p2.getX() - p3.getX());
        int firstLineY = Math.abs(p1.getY() - p2.getY());
        int secondLineY = Math.abs(p2.getY() - p3.getY());

        boolean sameRate = firstLineX == secondLineX && firstLineY == secondLineY;
        boolean sameCoordinate = (p1.getX() == p2.getX()) && (p1.getX() == p3.getX()) || (p1.getY() == p2.getY()) && (p1.getY() == p3.getY());
        return sameRate || sameCoordinate;
    }
}
