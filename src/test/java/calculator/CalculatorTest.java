package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import calculator.util.ErrorMessage;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CalculatorTest {

    @ParameterizedTest
    @DisplayName("List<String>형태인 숫자조합을 더한다")
    @MethodSource("provideNumber")
    void add(List<String> digits, int answer) throws Exception {
        // given

        // when
        int sum = Calculator.sumPositiveNumbers(digits);

        // then
        assertThat(sum).isEqualTo(answer);
    }


    private static Stream<Arguments> provideNumber(){
        return Stream.of(
                Arguments.arguments(List.of("1", "2", "3", "4"), 10),
                Arguments.arguments(List.of("3", "3", "4", "5"), 15),
                Arguments.arguments(List.of(), 0)
        );
    }

    @ParameterizedTest
    @DisplayName("숫자중에 음수가 있으면 에러를 내뿜는다")
    @MethodSource("provideNegativeNumber")
    void negative(List<String> digits) throws Exception {
        // then
        assertThatThrownBy(() -> Calculator.sumPositiveNumbers(digits))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_POSITIVE_NUMBER);

    }


    private static Stream<Arguments> provideNegativeNumber(){
        return Stream.of(
                Arguments.arguments(List.of("-1", "2", "3", "4")),
                Arguments.arguments(List.of("3", "-3", "4", "5"))
        );
    }

    @ParameterizedTest
    @DisplayName("주어진 List중에 숫자가 아니면 오류를 내뿜는다")
    @MethodSource("provideNotNumber")
    void notNumber(List<String> digits) throws Exception {
        // then
        assertThatThrownBy(() -> Calculator.sumPositiveNumbers(digits))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_DIGIT);

    }


    private static Stream<Arguments> provideNotNumber(){
        return Stream.of(
                Arguments.arguments(List.of("a", "2", "3", "4")),
                Arguments.arguments(List.of("3", "b", "4", "5"))
        );
    }

}