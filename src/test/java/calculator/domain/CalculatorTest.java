package calculator.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CalculatorTest {
    @Test
    void 피연산자들을_모두_더한다(){
        // given & when
        final var calculator = new Calculator(Arrays.asList(1.0, 2.0, 3.0));
        double result = calculator.plus();

        // then
        assertThat(result).isEqualTo(6);
    }

    @Test
    void 계산기의_피연사자는_모두_양수이다_음수일_경우(){
        // when & then
        assertThatThrownBy(() -> new Calculator(Arrays.asList(1.0, -2.0, 3.0)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("피연산자가 양수가 아닙니다.");
    }
}