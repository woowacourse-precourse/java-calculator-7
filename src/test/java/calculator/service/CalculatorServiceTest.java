package calculator.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceTest {
    CalculatorService calculatorService = new CalculatorService();

    @Test
    void executeAdd() {
        // given

        // when
        Integer answer = calculatorService.executeAdd("1,2:3");
        // then
        assertEquals(6, answer);
    }
}