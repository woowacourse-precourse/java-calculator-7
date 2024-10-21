package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class StringAddCalculatorTest {

    @Test
    void 빈문자열이_입력되면_0을_반환한다() {
        // given
        String input = "";

        // when
        int result = StringAddCalculator.add(input);

        // then
        assertThat(result).isEqualTo(0);
    }

    @Test
    void null이_입력되면_예외가_발생한다() {
        // given
        String input = null;

        // when & then
        assertThatThrownBy(() -> StringAddCalculator.add(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력이 null입니다.");
    }
}
