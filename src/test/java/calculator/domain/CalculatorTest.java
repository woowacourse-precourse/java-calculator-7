package calculator.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @DisplayName("계산기 더하기 성공")
    @Test
    void sumTest() {
        // given
        String inputValue = "1,2:3";

        // when
        Calculator calc = new Calculator(inputValue);

        // then
        assertThat(calc.sum()).isEqualTo(6);
    }
}
