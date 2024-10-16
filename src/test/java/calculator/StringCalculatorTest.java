package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import calculator.domain.StringCalculator;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {

    @Test
    void 빈_문자열_입력() {
        assertThat(StringCalculator.calculate("")).isEqualTo(0);
    }

    @Test
    void null_문자열_입력() {
        assertThat(StringCalculator.calculate(null)).isEqualTo(0);
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

    @Test
    void 숫자_하나() {
        assertThat(StringCalculator.calculate("1")).isEqualTo(1);
    }

}
