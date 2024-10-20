package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {

    private final StringAddCalculator calculator = new StringAddCalculator();

    @Test
    void addTest() {
        // given
        final String input = "";
        // when
        String add = calculator.add(input);
        // then
        assertThat(add).matches("0");
    }

    @Test
    void 커스텀구분자테스트() {
        // given
        final String input = "//.\\n1.2.3.4.5"; // 15
        // when
        String add = calculator.add(input);
        // then
        assertThat(add).matches("15");
    }

    @Test
    void 커스텀구분자실패케이스() {
        // given
        final String input = "//.\\n1.2.3.4,7";
        // when && then
        assertThatThrownBy(() -> calculator.add(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
