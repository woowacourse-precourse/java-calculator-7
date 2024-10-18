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
    @DisplayName("빈 문자열 배열을 파싱한 경우 0을 반환한다.")
    void calculateWithEmptyArray() {
        String[] input = {};
        int result = calculator.calculate(input);
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("유효한 숫자 하나를 파싱한 경우 해당 숫자를 반환한다.")
    void calculateWithSingleValidNumber() {
        String[] input = {"1"};
        int result = calculator.calculate(input);
        assertThat(result).isEqualTo(1);
    }
}