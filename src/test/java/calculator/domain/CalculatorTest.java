package calculator.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

public class CalculatorTest {
    @Test
    void 덧셈_테스트() {
        Separator separator = new Separator("1,2,3:4,5:6");
        Calculator calculator = new Calculator();

        assertThat(calculator.sum(separator.getElements())).isEqualTo(21);
    }
}
