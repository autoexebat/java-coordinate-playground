package coordinate.shape;

import coordinate.point.Point;
import coordinate.point.Points;

import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Rectangle extends Shape implements Computable {
    public Rectangle(Points points) {
        super(points);
        validate();
    }

    @Override
    public double compute() {
        Set<Integer> uniqueX = collectUniqueCoordinatesXY(point -> point.getX());
        Set<Integer> uniqueY = collectUniqueCoordinatesXY(point -> point.getY());
        return absDistance(uniqueX) * absDistance(uniqueY);
    }

    private int absDistance(Set<Integer> unique) {
        return Math.abs(unique.stream().reduce((x,y) -> x-y).get());
    }

    private Set<Integer> collectUniqueCoordinatesXY(Function<Point, Integer> function) {
        Points points = this.getPoints();
        return points.searchPointList().stream().map(function)
                .collect(Collectors.toSet());
    }

    private void validate() {
        int validateNum = 2;
        Set<Integer> uniqueX = collectUniqueCoordinatesXY(point -> point.getX());
        Set<Integer> uniqueY = collectUniqueCoordinatesXY(point -> point.getY());
        if(validateNum != uniqueX.size() || validateNum != uniqueY.size()) {
            throw new IllegalArgumentException("정사각형이 아닙니다.");
        }
    }
}
