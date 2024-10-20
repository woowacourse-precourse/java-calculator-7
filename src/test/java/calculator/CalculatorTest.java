package calculator;

import calculator.model.Calculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    Calculator calculator = new Calculator();

    @Test
    void testAddWithValidInput() {
        String[] numbers = {"1", "2", "3"};
        int result = calculator.add(numbers);
        assertEquals(6, result);
    }

    @Test
    void testAddWithEmptyArray() {
        String[] numbers = {};
        int result = calculator.add(numbers);
        assertEquals(0, result); // 빈 입력의 경우 0 반환
    }

    @Test
    void testAddWithSingleNumber() {
        String[] numbers = {"5"};
        int result = calculator.add(numbers);
        assertEquals(5, result); // 하나의 숫자만 있는 경우
    }

    @Test
    void testAddWithZero() {
        String[] numbers = {"0", "0", "0"};
        int result = calculator.add(numbers);
        assertEquals(0, result); // 0만 있는 경우
    }
}
