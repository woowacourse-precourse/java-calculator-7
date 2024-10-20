package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

/**
 * CalculatorTest
 */
public class CalculatorTest {

    private Calculator calculator = new Calculator();

    @Test
    void add_four_numbers() {
        int[] numbers = { 1, 2, -3, 4 };

        int sum = calculator.addNumbers(numbers);

        assertThat(sum).isEqualTo(4);
    }

}
