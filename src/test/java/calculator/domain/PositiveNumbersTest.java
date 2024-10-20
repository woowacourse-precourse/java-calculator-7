package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class PositiveNumbersTest {

    @Test
    @DisplayName("양수들: 0은 기본값, 덧셈에 영향을 주지 않는다")
    void 양수들_0은_기본값으로_포함하지_않는다() {
        assertThatNoException().isThrownBy(() ->
                PositiveNumbers.from(List.of("0", "1", "2", "3")));
    }

    @MethodSource(value = "provideNumbersAndExpectedValue")
    @ParameterizedTest(name = "피연산자: {0}, 기대값: {1}")
    void 덧셈_계산_성공(List<String> numbers, PositiveNumber expected) {
        PositiveNumbers positiveNumbers = PositiveNumbers.from(numbers);

        assertThat(positiveNumbers.sum()).isEqualTo(expected);
    }

    @Test
    @DisplayName("덧셈 결과가 15자리를 초과하면 실패한다")
    void 덧셈_계산_실패() {
        PositiveNumbers positiveNumbers = PositiveNumbers.from(List.of("1", "999999999999999"));

        assertThatThrownBy(positiveNumbers::sum)
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> provideNumbersAndExpectedValue() {
        return Stream.of(
                Arguments.of(List.of(""), PositiveNumber.zero()),
                Arguments.of(List.of("", "1"), PositiveNumber.from("1")),
                Arguments.of(List.of("0", "1"), PositiveNumber.from("1")),
                Arguments.of(List.of("0", "1", "2", "3"), PositiveNumber.from("6")),
                Arguments.of(List.of("1", "999999999999998"), PositiveNumber.from("999999999999999"))
        );
    }

}
