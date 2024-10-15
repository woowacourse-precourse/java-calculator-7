package calculator;

import calculator.domain.StringCalculator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    @Test
    void 빈_문자열() {
        assertThat(StringCalculator.calculate("")).isEqualTo(0);
    }

    @Test
    void 구분자_콤마() {
        assertThat(StringCalculator.calculate("1,2,3")).isEqualTo(6);
    }

    @Test
    void 구분자_콜론() {
        assertThat(StringCalculator.calculate("1:2:3")).isEqualTo(6);
    }

    @Test
    void 구분자_컴마_콜론() {
        assertThat(StringCalculator.calculate("1,2:3")).isEqualTo(6);
    }

    @Test
    void 커스텀_구분자() {
        assertThat(StringCalculator.calculate("//;\\n1;2;3")).isEqualTo(6);
    }

}
