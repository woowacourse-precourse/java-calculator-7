package calculator.infrastructure;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import calculator.exception.OutOfLongRangeException;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class NumberAddProcessorTest {


    @ParameterizedTest
    @MethodSource("provideNumberListAndExpectedSum")
    void 숫자_리스트의_요소를_모두_더해_성공적으로_반환하는_테스트(List<Long> numberList, Long expectedSum) {
        NumberAddProcessor numberAddProcessor = new NumberAddProcessor();
        assertThat(numberAddProcessor.addAllNumbers(numberList)).isEqualTo(expectedSum);
    }

    private static Stream<Arguments> provideNumberListAndExpectedSum() {
        return Stream.of(
                Arguments.of(List.of(123L, 100L, 10L, 1L), 234L),
                Arguments.of(List.of(123456L, 10000L, 1000L, 100L, 10L, 1L), 134567L),
                Arguments.of(List.of(5000000L, 5000000L), 10000000L),
                Arguments.of(List.of(500000000000000000L, 500000000000000000L), 1000000000000000000L)
        );
    }

    @ParameterizedTest
    @MethodSource("provideInvalidNumberList")
    void 숫자_리스트의_요소를_모두_더한_결과_Long_범위를_벗어나_예외를_발생시키는_테스트(List<Long> numberList) {
        NumberAddProcessor numberAddProcessor = new NumberAddProcessor();
        assertThatThrownBy(() -> numberAddProcessor.addAllNumbers(numberList))
                .isInstanceOf(OutOfLongRangeException.class);
    }

    private static Stream<Arguments> provideInvalidNumberList() {
        return Stream.of(
                Arguments.of(List.of(9223372036854775807L, 9223372036854775807L)),
                Arguments.of(List.of(5000000000000000000L, 5000000000000000000L))
        );
    }
}