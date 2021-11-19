package coordinate.shape;

import coordinate.point.Points;

public class Line extends Shape implements Computable {
    public Line(Points points) {
        super(points);
    }

    @Override
    public double compute() {
        return getDistance(0, 1);
    }
}
