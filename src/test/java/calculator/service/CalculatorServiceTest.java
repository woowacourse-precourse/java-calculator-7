package calculator.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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

    @Test
    @DisplayName("\n 앞에 '\' 를 붙이지 않으면 테스트는 실패한다.")
    void 커스텀구분자_더하기_예외_테스트1() {
        int add = calculatorService.customAdd("//;\n1;2;3");
        assertEquals(6, add);
    }


}