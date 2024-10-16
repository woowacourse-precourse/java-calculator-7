package calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    @Test
    @DisplayName("기본 구분자를 기준으로 한 각 숫자들의 합 계산")
    void basic_separator() {
        assertThat(Calculator.calculate("1,2:3")).isEqualTo(6);
        assertThat(Calculator.calculate("1:2:3")).isEqualTo(6);
        assertThat(Calculator.calculate("1,2,3")).isEqualTo(6);
    }
}