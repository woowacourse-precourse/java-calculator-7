package calculator.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CalculatorControllerTests {

    @ParameterizedTest
    @DisplayName("입력한 문자열의 덧셈 결과가 정수")
    @CsvSource(value = {"1:2:3", "1.0:2.0:3.0"})
    public void testIfResultInteger(String input) {
        String result1 = CalculatorController.sum(BigDecimal.ZERO, input);
        String result2 = CalculatorController.sum(0, input);

        assertThat(String.format("결과: %s", result1)).contains("결과: 6");
        assertThat(String.format("결과: %s", result2)).contains("결과: 6");
    }

    @Test
    @DisplayName("입력한 문자열의 덧셈 결과가 소수점 이하 자릿수가 존재하는 실수")
    public void testIfResultDecimal() {
        String input = "1.1:2.2:3.3";
        String result1 = CalculatorController.sum(BigDecimal.ZERO, input);
        String result2 = CalculatorController.sum(0, input);

        assertThat(String.format("결과: %s", result1)).contains("결과: 6.6");
        assertThat(String.format("결과: %s", result2)).contains("결과: 6.6");
    }
}