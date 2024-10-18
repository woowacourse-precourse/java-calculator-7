package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("빈 문자열 배열을 입력할 경우 0을 반환해야 한다.")
    void calculateWithEmptyArray() {
        String[] input = {};
        int result = calculator.calculate(input);
        assertThat(result).isEqualTo(0);
    }
}