package calculator.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculationServiceTest {
    private CalculationService calculationService;

    @BeforeEach
    void setUp(){
        calculationService = new CalculationService();
    }

    @Test
    void 숫자의합(){
        int[] numbers = {1,2,3};
        assertEquals(calculationService.calculate(numbers), 6);
    }
}