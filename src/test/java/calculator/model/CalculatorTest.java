package calculator.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {

    private Calculator calculator = new Calculator();

    @Test
    void 문자열을_받아_더한값을_전달한다() {
        String input = "1,2:3";
        int expectedSum = 1 + 2 + 3;

        int actual = calculator.sumNumbersFromString(input);

        assertEquals(expectedSum, actual);
    }
}