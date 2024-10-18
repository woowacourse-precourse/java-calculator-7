package calculator.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceTest {
    CalculatorService calculatorService = new CalculatorService();

    @DisplayName("커스텀 구분자가 없는 경우")
    @Test()
    void executeAdd() {
        // given
        // when
        Integer answer = calculatorService.executeAdd("1,2:3");
        // then
        assertEquals(6, answer);
    }

    @DisplayName("커스텀 구분자가 있는 경우")
    @Test()
    void executeAddWithCustomSeparator() {
        // given
        // when
        Integer answer = calculatorService.executeAdd("//;\n1;2;3");
        // then
        assertEquals(6, answer);
    }
}