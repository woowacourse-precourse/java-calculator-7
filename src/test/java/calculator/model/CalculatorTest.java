package calculator.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    void 단일_숫자의_배열_합_테스트() {
        int[] intArray = {5};
        String result = calculator.calculate(intArray);
        assertEquals("5", result);
    }

    @Test
    void 여러_숫자의_배열_합_테스트() {
        int[] intArray = {1, 2, 3, 4, 5};
        String result = calculator.calculate(intArray);
        assertEquals("15", result);
    }
}
