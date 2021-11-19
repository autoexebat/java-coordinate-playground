package coordinate.shape;

import coordinate.point.Points;
import coordinate.point.PointsFactory;
import org.assertj.core.api.Assertions;
import org.assertj.core.data.Offset;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class RectangleTest {
    @ParameterizedTest
    @ValueSource(strings = {"(10,10)-(22,11)-(21,18)-(12,19)"})
    void notSquare(String input) {
        Points points = PointsFactory.of(input);
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> ShapeFactory.create(points))
                .withMessage("정사각형이 아닙니다.");
    }

    @ParameterizedTest
    @CsvSource(value = {"(10,10)-(22,10)-(22,18)-(10,18):96"}, delimiter = ':')
    void area(String input, double result) {
        Points points = PointsFactory.of(input);
        Shape shape = ShapeFactory.create(points);
        Assertions.assertThat(shape.compute()).isEqualTo(result, Offset.offset(0.00099));
    }
}
