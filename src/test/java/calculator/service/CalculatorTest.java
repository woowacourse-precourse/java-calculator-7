package calculator.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    @Test
    @DisplayName("합계 테스트")
    public void sumTest() {
        Calculator calculator = new Calculator();
        String input = "//;\\n1;2;3";
        int sum = calculator.sum(input);

        Assertions.assertThat(6).isEqualTo(sum);
    }
}
