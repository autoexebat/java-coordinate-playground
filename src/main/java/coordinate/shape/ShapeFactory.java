package coordinate.shape;

import coordinate.point.Points;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class ShapeFactory {
    private static final Map<Integer, Function<Points, Shape>> factory = new HashMap<>();

    static {
        factory.put(2, Line::new);
        factory.put(3, Triangle::new);
        factory.put(4, Rectangle::new);
    }

    public static Shape create(Points points) {
        return factory.get(points.numberOfPoints()).apply(points);
    }
}
