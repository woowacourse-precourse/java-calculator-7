package calculator;

import static org.assertj.core.api.Assertions.assertThat;

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
}
