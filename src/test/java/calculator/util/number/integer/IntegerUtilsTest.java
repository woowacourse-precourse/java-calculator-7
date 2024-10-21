package calculator.util.number.integer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("NumberUtils 클래스")
public class IntegerUtilsTest {

    static Stream<Arguments> provideIntegerConvertInput() {
        return Stream.of(
                Arguments.of(List.of("-1", "2", "3"), List.of(-1, 2, 3)),
                Arguments.of(List.of("1", "2", "-3", "4"), List.of(1, 2, -3, 4)),
                Arguments.of(List.of("1", "2", "3", "4", "5"), List.of(1, 2, 3, 4, 5))
        );
    }

    static Stream<Arguments> provideIntegerSumInput() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3), 6),
                Arguments.of(List.of(1, 2, 3, 4), 10),
                Arguments.of(List.of(1, 2, 3, 4, 5), 15),
                Arguments.of(List.of(1, 2, 3, 4, 5, -6), 9)
        );
    }

    @ParameterizedTest(name = "정수 문자열 리스트: {0}, 기대값: {1}")
    @MethodSource("provideIntegerConvertInput")
    void 정수_문자열_리스트를_정수로_변환한다(List<String> input, List<Integer> expected) {

        // when
        List<? extends Number> actual = IntegerUtils.parseIntegers(input);

        // then
        assertEquals(expected, actual);
    }

    @ParameterizedTest(name = "정수 리스트: {0}, 기대값: {1}")
    @MethodSource("provideIntegerSumInput")
    void 정수_리스트의_합계를_계산한다(List<Integer> values, int expected) {

        // when
        Number actual = IntegerUtils.sum(values);

        // then
        assertEquals(expected, actual);
    }
}
