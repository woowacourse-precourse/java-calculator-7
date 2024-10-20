package calculator.core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    @DisplayName("[정상] 객체 생성")
    @Test
    void instance() {
        // given & when
        Calculator calculator = Calculator.enterValue("1,2:3");
        // then
        assertNotNull(calculator);
    }

    @DisplayName("[정상] 기본 객체로 더하기 연산")
    @Test
    void defaultSum() {
        // given & when
        Calculator calculator = Calculator.enterValue("1,2:3");
        // then
        assertEquals(6, calculator.sum());
    }

    @DisplayName("[정상] 커스텀 객체로 더하기 연산")
    @Test
    void customSum() {
        // given & when
        Calculator calculator = Calculator.enterValue("//;\\n1;2;3");
        // then
        assertEquals(6, calculator.sum());
    }
}