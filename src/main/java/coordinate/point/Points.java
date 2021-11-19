package coordinate.point;

import java.util.List;

public class Points {
    private List<Point> points;

    public Points(List<Point> points) {
        this.points = points;
    }

    public List<Point> searchPointList() {
        return points;
    }

    public Point getSpecificPoint(int index) {
        return points.get(index);
    }

    public int numberOfPoints() {
        return points.size();
    }
}
