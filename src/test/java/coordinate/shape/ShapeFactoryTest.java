package coordinate.shape;

import coordinate.point.Points;
import coordinate.util.StringParser;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ShapeFactoryTest {
    @ParameterizedTest
    @ValueSource(strings = {"(10,10)-(14,15)"})
    void line(String input) {
        Points points = StringParser.parse(input);
        Shape shape = ShapeFactory.create(points);
        Assertions.assertThat(shape instanceof Line).isEqualTo(true);
    }

    @ParameterizedTest
    @ValueSource(strings = {"(10,10)-(14,15)-(20,8)"})
    void triangle(String input) {
        Points points = StringParser.parse(input);
        Shape shape = ShapeFactory.create(points);
        Assertions.assertThat(shape instanceof Triangle).isEqualTo(true);
    }

    @ParameterizedTest
    @ValueSource(strings = {"(10,10)-(22,10)-(22,18)-(10,18)"})
    void rectangle(String input) {
        Points points = StringParser.parse(input);
        Shape shape = ShapeFactory.create(points);
        Assertions.assertThat(shape instanceof Rectangle).isEqualTo(true);
    }
}
