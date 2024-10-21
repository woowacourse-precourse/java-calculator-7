package calculator;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {
    @Test
    void 양수_합산_테스트() {
        Calculator calculator = new Calculator();
        String[] tokens = {"1", "2", "3"};
        int result = calculator.calculateSum(tokens);
        assertThat(result).isEqualTo(6);
    }

    @Test
    void 음수_예외_테스트() {
        Calculator calculator = new Calculator();
        String[] tokens = {"-1", "2", "3"};
        assertThatThrownBy(() -> calculator.calculateSum(tokens))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("음수 값이 포함되어 있습니다.");
    }
}
