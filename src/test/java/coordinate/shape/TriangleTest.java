package coordinate.shape;

import coordinate.point.Points;
import coordinate.point.PointsFactory;
import org.assertj.core.api.Assertions;
import org.assertj.core.data.Offset;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class TriangleTest {
    @ParameterizedTest
    @ValueSource(strings = {"(10,5)-(10,10)-(10,15)"})
    void sameLineX(String input) {
        Points points = PointsFactory.of(input);
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> ShapeFactory.create(points));
    }

    @ParameterizedTest
    @ValueSource(strings = {"(5,10)-(5,21)-(5,15)"})
    void sameLineY(String input) {
        Points points = PointsFactory.of(input);
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> ShapeFactory.create(points));
    }

    @ParameterizedTest
    @ValueSource(strings = {"(5,10)-(10,15)-(15,20)"})
    void sameRate(String input) {
        Points points = PointsFactory.of(input);
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> ShapeFactory.create(points));
    }

    @ParameterizedTest
    @CsvSource(value = {"(10,10)-(14,15)-(20,8):29"}, delimiter = ':')
    void area(String input, double result) {
        Points points = PointsFactory.of(input);
        Shape shape = ShapeFactory.create(points);
        Assertions.assertThat(shape.compute()).isEqualTo(result, Offset.offset(0.00099));
    }
}
