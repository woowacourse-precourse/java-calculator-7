package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class StringAddCalculatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    void null_또는_빈문자_계산(String value) {
        StringAddCalculator stringAddCalculator = new StringAddCalculator();
        assertThat(stringAddCalculator.splitAndSum(value)).isEqualTo(0);
    }

    @Test
    void 숫자하나_계산() {
        StringAddCalculator stringAddCalculator = new StringAddCalculator();
        assertThat(stringAddCalculator.splitAndSum("1")).isEqualTo(1);
    }

    @Test
    void 쉼표_또는_콜론_구분자_계산() {
        StringAddCalculator stringAddCalculator = new StringAddCalculator();
        assertThat(stringAddCalculator.splitAndSum("1,2:3")).isEqualTo(6);
    }

    @Test
    void 쉼표_구분자_계산() {
        StringAddCalculator stringAddCalculator = new StringAddCalculator();
        assertThat(stringAddCalculator.splitAndSum("1,2,3")).isEqualTo(6);
    }

    @Test
    void 콜론_구분자_계산() {
        StringAddCalculator stringAddCalculator = new StringAddCalculator();
        assertThat(stringAddCalculator.splitAndSum("1:2:3")).isEqualTo(6);
    }

    @Test
    void 숫자가_아닌값_검증() {
        StringAddCalculator stringAddCalculator = new StringAddCalculator();
        assertThatThrownBy(() -> stringAddCalculator.splitAndSum("일,2:3"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
