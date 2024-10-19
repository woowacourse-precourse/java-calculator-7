package calculator.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    @Test
    @DisplayName("기본 구분자 (쉼표, 콜론)로 문자열을 계산")
    void testCalculateWithDefaultDelimiters() {
        // given
        String input = "1,2:3";

        // when
        int result = ExpressionCalculator.calculate(input);

        // then
        assertEquals(6, result);
    }

    @Test
    @DisplayName("커스텀 구분자 세미콜론(;)로 문자열을 계산")
    void testCalculateWithCustomDelimiter() {
        // given
        String input = "//;\\n1;2;3";

        // when
        int result = ExpressionCalculator.calculate(input);

        // then
        assertEquals(6, result);
    }

    @Test
    @DisplayName("커스텀 구분자와 기본 구분자 모두 포함된 문자열을 계산")
    void testCalculateWithCustomAndDefaultDelimiters() {
        // given
        String input = "//;\\n1;2,3";

        // when
        int result = ExpressionCalculator.calculate(input);

        // then
        assertEquals(6, result);
    }

    @Test
    @DisplayName("구분자 없이 숫자만 입력")
    void testCalculateWithNoDelimiter() {
        // given
        String input1 = "7";
        String input2 = "77"; // 두 자리 수 입력 케이스

        // when
        int result1 = ExpressionCalculator.calculate(input1);
        int result2 = ExpressionCalculator.calculate(input2);

        // then
        assertEquals(7, result1);
        assertEquals(77, result2);
    }
}
