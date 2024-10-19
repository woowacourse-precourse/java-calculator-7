package calculator.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
    }

    @Test
    void sum() {
        List<Integer> numbers = Arrays.asList(1, 2, 3);
        calculator = new Calculator(numbers);
        calculator.sum();

        assertEquals(6, calculator.getResult());
    }
}