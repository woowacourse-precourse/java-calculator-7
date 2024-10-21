package calculator.infrastructure;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import calculator.common.exception.OutOfLongRangeException;
import calculator.domain.Number;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SumCalculatorTest {

    private SumCalculator sumCalculator;

    @BeforeEach
    void setUp() {
        sumCalculator = new SumCalculator();
    }

    @ParameterizedTest
    @MethodSource("provideNumberListAndExpectedSum")
    void 숫자_리스트의_요소를_모두_더해_성공적으로_반환하는_테스트(List<Number> numberList, Long expectedSum) {
        assertThat(sumCalculator.addAllNumbers(numberList)).isEqualTo(expectedSum);
    }

    private static Stream<Arguments> provideNumberListAndExpectedSum() {
        return Stream.of(
                Arguments.of(List.of(new Number("00123"), new Number("000000100"), new Number("10"), new Number("1")),
                        234L),
                Arguments.of(List.of(new Number("123456"), new Number("10000"), new Number("1000"),
                        new Number("100"), new Number("10"), new Number("1")), 134567L),
                Arguments.of(List.of(new Number("5000000"), new Number("5000000")), 10000000L),
                Arguments.of(List.of(new Number("500000000000000000"), new Number("500000000000000000")),
                        1000000000000000000L)
        );
    }

    @ParameterizedTest
    @MethodSource("provideInvalidNumberList")
    void 숫자_리스트의_요소를_모두_더한_결과_Long_범위를_벗어나_예외를_발생시키는_테스트(List<Number> numberList) {
        assertThatThrownBy(() -> sumCalculator.addAllNumbers(numberList))
                .isInstanceOf(OutOfLongRangeException.class);
    }

    private static Stream<Arguments> provideInvalidNumberList() {
        return Stream.of(
                Arguments.of(List.of(new Number("9223372036854775807"), new Number("1"))),
                Arguments.of(List.of(new Number("5000000000000000000"), new Number("5000000000000000000")))
        );
    }
}