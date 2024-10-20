package calculator.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CalculatorServiceTest {

    CalculatorService calculatorService = CalculatorService.getInstance();

    @Test
    public void testFindSeparator_haveSeparator() {
        String haveSeparator = "//;\\n1;2;3";

        assertEquals(calculatorService.findSeparator(haveSeparator), "1;2;3", "calculatorService: 커스텀 문자열이 있을 때 오류");
    }

    @Test
    public void testFindSeparator_notHaveSeparator() {
        String notHaveSeparator = "1,2:3";

        assertEquals(calculatorService.findSeparator(notHaveSeparator), "1,2:3", "calculatorService: 커스텀 문자열이 없을 때 오류");
    }

    @Test
    public void testCalculate() {
        String targetText = "1,2:3";

        assertEquals(calculatorService.calculate(targetText), 6, "calculatorService: 계산 과정 오류");
    }
}
