package calculator.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorServiceTest {
    private CalculatorService calculatorService;

    @BeforeEach
    public void setUp() {
        calculatorService = new CalculatorService();
    }

    @Test
    void 기본구분자_더하기_테스트() {
        int add = calculatorService.defaultAdd("1:2,3");
        assertEquals(6, add);
    }

    @Test
    void 커스텀구분자_더하기_테스트() {
        int add = calculatorService.customAdd("//;\\n1;2;3");
        assertEquals(6, add);
    }


}