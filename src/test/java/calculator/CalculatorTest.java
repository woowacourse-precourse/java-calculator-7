package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void 빈_문자열을_입력하면_결과는_0() {
        // given
        String userInput = "";

        // when
        int result = calculator.processInputAndSum(userInput);

        // then
        assertThat(result).isEqualTo(0);
    }
}
