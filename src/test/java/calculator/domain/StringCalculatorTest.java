package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringCalculatorTest {

    @Test
    @DisplayName("입력된 문자열에 대한 합을 반환한다.")
    void sum() {
        // given
        String input = "1,2,3";
        StringCalculator calculator = new StringCalculator(input);

        // when
        int result = calculator.sum();

        // then
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("커스텀 구분자가 존재할 경우, 커스텀 구분자 입력에 대한 문자열을 제외한 입력의 합을 반환한다.")
    void sumWithCustomDelimiter() {
        // given
        String input = "//;\\n1;2:3";
        StringCalculator calculator = new StringCalculator(input);

        // when
        int result = calculator.sum();

        // then
        assertThat(result).isEqualTo(6);
    }
}