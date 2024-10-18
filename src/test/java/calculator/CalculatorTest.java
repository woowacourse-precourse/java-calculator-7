package calculator;

import calculator.domain.Calculator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    void 빈_문자열_또는_null_입력() {
        assertThat(calculator.splitAndSum("")).isZero();
        assertThat(calculator.splitAndSum(null)).isZero();
    }
}
