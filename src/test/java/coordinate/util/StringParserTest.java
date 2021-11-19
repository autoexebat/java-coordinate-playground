package coordinate.util;

import coordinate.point.Points;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class StringParserTest {
    @ParameterizedTest
    @CsvSource(value = {"(10,10)-(14,15):2", "(10,10)-(14,15)-(1,2):3"}, delimiter = ':')
    void parse(String input, int size) {
        Points points = StringParser.parse(input);
        Assertions.assertThat(points.numberOfPoints()).isEqualTo(size);
    }
    @ParameterizedTest
    @ValueSource(strings = {"(10,10)/(14,15)", "(-10,10)/(14,15)", "(-10,10)-(14,15)", "", "(10,10)"})
    void invalid(String input) {
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> StringParser.parse(input))
                .withMessage("잘못된 입력값이 들어왔습니다.");
    }
}
