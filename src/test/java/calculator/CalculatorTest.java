package calculator;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CalculatorTest {
    @DisplayName("문자열 리스트 안의 요소를 더할 수 있다.")
    @ParameterizedTest
    @MethodSource("provideValidNumbers")
    void 숫자_덧셈_성공(List<String> numbers, int expectedSum) {
        // when
        int sum = Calculator.numberSum(numbers);

        // then
        assertThat(sum).isEqualTo(expectedSum);
    }

    @DisplayName("리스트에 숫자가 아닌 값이 있으면 예외를 발생시킨다.")
    @ParameterizedTest
    @MethodSource("provideInvalidNumbers")
    void 숫자가_아닌_값_덧셈_실패(List<String> numbers) {
        // when then
        assertThatThrownBy(() -> Calculator.numberSum(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("리스트에 음수가 들어있으면 예외를 발생시킨다.")
    @ParameterizedTest
    @MethodSource("provideNegativeNumbers")
    void 음수_덧셈_실패() {
        // given
        List<String> numbers = List.of("1","-2","3");
        // when then
        assertThatThrownBy(() -> Calculator.numberSum(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> provideValidNumbers() {
        return Stream.of(
                Arguments.of(List.of("1", "2", "3"), 6),
                Arguments.of(List.of("10", "20", "30"), 60),
                Arguments.of(List.of("0", "0", "0"), 0)
        );
    }

    static Stream<Arguments> provideInvalidNumbers() {
        return Stream.of(
                Arguments.of(List.of("1", "a", "3")),
                Arguments.of(List.of("0", ":", "")),
                Arguments.of(List.of("안녕", "1", ","))
        );
    }

    static Stream<Arguments> provideNegativeNumbers() {
        return Stream.of(
                Arguments.of(List.of("1", "-2", "3")),
                Arguments.of(List.of("0", "20", "-30")),
                Arguments.of(List.of("-1", "-1", "-1"))
        );
    }
}