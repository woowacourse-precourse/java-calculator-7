package calculator.service;

import calculator.domain.CalcTarget;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceTest {

    private final CalculatorService calculatorService = new CalculatorService();

    @Test
    @DisplayName("기본 구분자 문자열 계산 테스트")
    void calculate() {
        // given
        String input = "1,2,3";
        CalcTarget calcTarget = CalcTarget.input(input);
        // when
        int result = calculatorService.calculate(calcTarget);
        // then
        assertEquals(6, result);
    }

    @Test
    @DisplayName("커스텀 구분자 문자열 계산 테스트")
    void calculateWithCustomSeparator() {
        // given
        String input = "//;\\n1;2;3";
        CalcTarget calcTarget = CalcTarget.input(input);
        // when
        int result = calculatorService.calculate(calcTarget);
        // then
        assertEquals(6, result);
    }

    @Test
    @DisplayName("커스텀, 기본 혼합 구분자 문자열 계산 테스트")
    void calculateWithMixedSeparator() {
        // given
        String input = "//;\\n1;2,3";
        CalcTarget calcTarget = CalcTarget.input(input);
        // when
        int result = calculatorService.calculate(calcTarget);
        // then
        assertEquals(6, result);
    }

}