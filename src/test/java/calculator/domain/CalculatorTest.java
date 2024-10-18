package calculator.domain;

import static calculator.exception.constants.ErrorMessage.INVALID_INPUT_VALUE;
import static calculator.exception.constants.ErrorMessage.NEGATIVE_VALUE_NOT_ALLOWED;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import calculator.exception.CalculatorException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class CalculatorTest {

    @ParameterizedTest(name = "입력값: {0}, 기대값: {1}")
    @MethodSource("providePositiveNumber")
    void 양수_더하기(String[] splitInputs, long expected) {
        // given
        Calculator calculator = new Calculator(splitInputs);

        // when
        long result = calculator.sum();

        // then
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest(name = "입력값: {0}")
    @ValueSource(strings = {"a", "1.2", "a,b", "1,a,3", "1.2,2,3"})
    void 예외_테스트_문자_또는_실수가_포함된_더하기(String input) {
        // given
        String[] splitInputs = input.split(",");
        Calculator calculator = new Calculator(splitInputs);

        // when & then
        assertThatThrownBy(calculator::sum)
                .isInstanceOf(CalculatorException.class)
                .hasMessage(INVALID_INPUT_VALUE.getMessage());
    }

    @ParameterizedTest(name = "입력값: {0}")
    @ValueSource(strings = {"-1", "0", "0,1", "-1,2,3", "-1,-2,-3"})
    void 예외_테스트_양수가_아닌_수가_포함된_더하기(String input) {
        // given
        String[] splitInputs = input.split(",");
        Calculator calculator = new Calculator(splitInputs);

        // when & then
        assertThatThrownBy(calculator::sum)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NEGATIVE_VALUE_NOT_ALLOWED.getMessage());
    }

    static Stream<Arguments> providePositiveNumber() {
        return Stream.of(
                Arguments.of(new String[]{"1"}, 1L),
                Arguments.of(new String[]{"1", "2"}, 3L),
                Arguments.of(new String[]{"1", "2", "3"}, 6L)
        );
    }
}