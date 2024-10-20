package calculator.service.impl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorServiceImplTest {

    private CalculatorServiceImpl calculatorService;

    @BeforeEach
    void setUp() {
        calculatorService = new CalculatorServiceImpl();
    }

    @Test
    void simpleCalculateTest() {
        // Given
        int[] numbers = {1, 2, 3, 4, 5};

        // When
        int result = calculatorService.calculate(numbers);

        // Then
        assertEquals(15, result);
    }

    @Test
    void emptyArrayCalculateTest() {
        // Given
        int[] numbers = {};

        // When
        int result = calculatorService.calculate(numbers);

        // Then
        assertEquals(0, result);
    }

    @Test
    void negativeNumbersArrayCalculateTest() {
        // Given
        int[] numbers = {-1, -2, -3, -4};

        // When
        int result = calculatorService.calculate(numbers);

        // Then
        assertEquals(-10, result);
    }

    @Test
    void onlyZeroArrayCalculateTest() {
        // Given
        int[] numbers = {0, 0, 0};

        // When
        int result = calculatorService.calculate(numbers);

        // Then
        assertEquals(0, result);
    }

    @Test
    void mixedPositiveAndNegativeNumbersArrayCalculateTest() {
        // Given
        int[] numbers = {1, -2, 3, -4, 5};

        // When
        int result = calculatorService.calculate(numbers);

        // Then
        assertEquals(3, result);
    }
}