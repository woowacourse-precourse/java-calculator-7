package calculator;

import calculator.io.Display;
import calculator.io.InputReceiver;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class SeparatorExpressionCalculatorTest {
    private int actual;

    @ParameterizedTest
    @DisplayName("주어진 문자열을 올바르게 계산하는지 확인")
    @MethodSource("generateExpressionAndAnswer")
    void testOperate(String expressionString, int expected) {
        InputReceiver inputReceiver = () -> expressionString;
        Display display = (result) -> actual = result;
        SeparatorExpressionCalculator calculator = new SeparatorExpressionCalculator(inputReceiver, display);

        calculator.operate();

        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> generateExpressionAndAnswer() {
        return Stream.of(
                Arguments.of("", 0),
                Arguments.of("1:1", 2),
                Arguments.of("1,1", 2),
                Arguments.of("1,1:1", 3),
                Arguments.of("1", 1),
                Arguments.of("//;\\n1;2;3", 6)
        );
    }

    @ParameterizedTest
    @DisplayName("식이 유효하지 않으면 IllegalArgumentException을 발생시키는지 확인")
    @MethodSource("generateIllegalExpression")
    void testOperateThrowIllegalArgumentException(String expressionString) {
        InputReceiver inputReceiver = () -> expressionString;
        Display emptyDisplay = (result) -> {
        };
        SeparatorExpressionCalculator calculator = new SeparatorExpressionCalculator(inputReceiver, emptyDisplay);

        assertThatThrownBy(calculator::operate).isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> generateIllegalExpression() {
        return Stream.of(
                Arguments.of(" "),
                Arguments.of("1:1,"),
                Arguments.of(",1,1"),
                Arguments.of("1,,1:1"),
                Arguments.of(":"),
                Arguments.of("/;\\n1;2;3"),
                Arguments.of("//\\n1;2;3"),
                Arguments.of("// \\n1;2;3"),
                Arguments.of("//a\\n\\n1;2;3"),
                Arguments.of("//a\\n//d\\n1;2;3")
        );
    }
}