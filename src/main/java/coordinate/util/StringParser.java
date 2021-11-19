package coordinate.util;

import coordinate.point.Point;
import coordinate.point.Points;

import java.util.ArrayList;
import java.util.List;

public class StringParser {
    public static Points parse(String input) {
        List<Point> res = new ArrayList<>();
        String[] points = input.split("-");
        for(String point : points) {
            res.add(extractPoint(point));
        }
        return new Points(res);
    }

    private static Point extractPoint(String input) {
        try {
            String[] points = input.replaceAll("\\(|\\)", "").split(",");
            return new Point(Integer.parseInt(points[0]), Integer.parseInt(points[1]));
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
