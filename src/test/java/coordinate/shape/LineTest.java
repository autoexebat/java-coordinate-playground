package coordinate.shape;

import coordinate.point.Points;
import coordinate.point.PointsFactory;
import org.assertj.core.api.Assertions;
import org.assertj.core.data.Offset;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LineTest {
    @ParameterizedTest
    @CsvSource(value = {"(10,10)-(14,15):6.403"}, delimiter = ':')
    void distance(String input, double result) {
        Points points = PointsFactory.of(input);
        Shape shape = ShapeFactory.create(points);
        Assertions.assertThat(shape.compute()).isEqualTo(result, Offset.offset(0.001));
    }


}
