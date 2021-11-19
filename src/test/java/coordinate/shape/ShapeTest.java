package coordinate.shape;

import coordinate.point.Points;
import coordinate.point.PointsFactory;
import org.assertj.core.api.Assertions;
import org.assertj.core.data.Offset;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class ShapeTest {
    @ParameterizedTest
    @ValueSource(strings = {"(10,10)-(10,10)"})
    void sameLine(String input) {
        Points points = PointsFactory.of(input);
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> ShapeFactory.create(points))
                .withMessage("중복되는는 좌표 입력되었습니다.");
    }

    @ParameterizedTest
    @CsvSource(value = {"(10,10)-(10,20):10"}, delimiter = ':')
    void distance(String input, double result) {
        Points points = PointsFactory.of(input);
        Shape shape = ShapeFactory.create(points);
        Assertions.assertThat(shape.getDistance(0, 1)).isEqualTo(result, Offset.offset(0.001));
    }
}
