package coordinate.shape;

import coordinate.point.Point;
import coordinate.point.Points;

import java.util.HashSet;
import java.util.Set;

public abstract class Shape implements Computable{
    private Points points;

    public Shape(Points points) {
        this.points = points;
        validate();
    }

    public Points getPoints() {
        return points;
    }

    public double getDistance(int from, int to) {
        Point p1 = points.getSpecificPoint(from);
        Point p2 = points.getSpecificPoint(to);
        double x = p1.getX() - p2.getX();
        double y = p1.getY() - p2.getY();
        return Math.sqrt((x*x) + (y*y));
    }

    private void validate() {
        if(hasOnlyUnique() == false) {
            throw new IllegalArgumentException("중복되는는 좌표 입력되었습니다.");
        }
    }

    private boolean hasOnlyUnique() {
        Set<Point> unique = new HashSet<>(points.searchPointList());
        return unique.size() == points.numberOfPoints();
    }

    @Override
    public double compute() {
        return 0;
    }
}
