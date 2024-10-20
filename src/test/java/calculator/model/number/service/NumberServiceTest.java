package calculator.model.number.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("NumberService 클래스")
public class NumberServiceTest {

    private final NumberService numberService = new NumberService();

    static Stream<Arguments> provideIntegerConvertInput() {
        return Stream.of(
                Arguments.of(List.of("-1", "2", "3"), List.of(-1, 2, 3), Integer.class),
                Arguments.of(List.of("1", "2", "-3", "4"), List.of(1, 2, -3, 4), Integer.class),
                Arguments.of(List.of("1", "2", "3", "4", "5"), List.of(1, 2, 3, 4, 5), Integer.class)
        );
    }

    static Stream<Arguments> provideIntegerSumInput() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3), 6, Integer.class),
                Arguments.of(List.of(1, 2, 3, 4), 10, Integer.class),
                Arguments.of(List.of(1, 2, 3, 4, 5), 15, Integer.class),
                Arguments.of(List.of(1, 2, 3, 4, 5, -6), 9, Integer.class)
        );
    }

    @ParameterizedTest(name = "문자열 리스트: {0}, 기대값: {1}")
    @MethodSource({
            "provideIntegerConvertInput"
    })
    void 문자열_리스트를_숫자로_변환한다(List<String> input, List<Number> expected, Class<? extends Number> numberClass) {

        // when
        List<? extends Number> actual = numberService.convertFrom(input, numberClass);

        // then
        assertEquals(expected, actual);
    }

    @ParameterizedTest(name = "리스트: {0}, 기대값: {1}")
    @MethodSource({
            "provideIntegerSumInput"
    })
    void 숫자_리스트의_합계를_계산한다(List<Number> values, int expected, Class<? extends Number> numberClass) {

        // when
        Number actual = numberService.sum(values, numberClass);

        // then
        assertEquals(expected, actual);
    }
}
