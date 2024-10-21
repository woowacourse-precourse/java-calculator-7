package calculator.controller;

import static org.assertj.core.api.Assertions.assertThat;

import calculator.dto.CalculatorResultDTO;
import calculator.dto.ExpressionDTO;
import java.math.BigDecimal;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

class CalculatorControllerTests {

    private ExpressionDTO expression;

    @ParameterizedTest
    @DisplayName("입력한 문자열의 덧셈 결과가 정수")
    @CsvSource(value = {"1:2:3", "1.0:2.0:3.0"})
    public void testIfResultInteger(String input) {
        expression = new ExpressionDTO(input);

        String expected = "결과: 6";
        BigDecimal result = CalculatorController.sum(BigDecimal.ZERO, expression);

        assertThat(String.format("결과: %s", new CalculatorResultDTO<>(result).getTotal())).startsWith(expected);
    }

    @Test
    @DisplayName("덧셈 결과가 Double형 범위 이내의 실수")
    public void testIfResultDoubleType() {
        String input = "1.1:2.2:3.3";
        expression = new ExpressionDTO(input);

        String expected = "결과: 6.6";
        BigDecimal result = CalculatorController.sum(BigDecimal.ZERO, expression);

        assertThat(String.format("결과: %s", new CalculatorResultDTO<>(result).getTotal())).startsWith(expected);
    }

    @ParameterizedTest
    @DisplayName("덧셈 결과가 Double형 범위 바깥의 실수")
    @MethodSource("provideStringToExpressionAndTotalSum")
    public void testIfResultBigDecimalType(String input, String expected) {
        expression = new ExpressionDTO(input);

        Double result1 = CalculatorController.sum(0, expression);
        BigDecimal result2 = CalculatorController.sum(BigDecimal.ZERO, expression);

        Assertions.assertNotEquals(new CalculatorResultDTO<>(result1).getTotal(), expected);
        Assertions.assertEquals(new CalculatorResultDTO<>(result2).getTotal(), expected);
    }
    private static Stream<Arguments> provideStringToExpressionAndTotalSum() {
        return Stream.of(
                Arguments.of("0.11111111111111111:0.44444444444444444", "0.55555555555555555"),
                Arguments.of("0.000000000000000005:0.000000000000000004", "0.000000000000000009")
        );
    }
}