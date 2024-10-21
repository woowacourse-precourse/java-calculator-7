package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import calculator.model.StringExpression;
import calculator.model.SumResult;
import calculator.service.SumCalculator;
import org.junit.jupiter.api.Test;

public class SumCalculatorTest {

    private final SumCalculator calculator = new SumCalculator();

    @Test
    void shouldReturnSumForValidNumbers() {
        SumResult result = calculator.calculate(new StringExpression("1,2,3"));
        assertEquals(6, result.getResult());
    }

    @Test
    void shouldThrowExceptionForNegativeNumbers() {
        assertThrows(IllegalArgumentException.class, () -> calculator.calculate(new StringExpression("1,-2,3")));
    }

    @Test
    void shouldThrowExceptionForInvalidNumbers() {
        assertThrows(IllegalArgumentException.class, () -> calculator.calculate(new StringExpression("1,a,3")));
    }

    @Test
    void shouldReturnSumWithMixedDelimiter() {
        SumResult result = calculator.calculate(new StringExpression("//;\n1,2:3;4;5"));
        assertEquals(15, result.getResult());
    }

    @Test
    void shouldReturnSumWithMixedDelimiters() {
        SumResult result = calculator.calculate(new StringExpression("//;\n//s\n1;2s3,4:5"));
        assertEquals(15, result.getResult());
    }
}
