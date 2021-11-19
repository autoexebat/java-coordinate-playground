package coordinate.point;

import coordinate.util.StringParser;

public class PointsFactory {
    public static Points of(String input) {
        return StringParser.parse(input);
    }
}
