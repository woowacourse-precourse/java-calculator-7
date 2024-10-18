package calculator.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static calculator.exception.util.CustomDelimiterExtractorErrorMessage.INVALID_CUSTOM_DELIMITER_FORMAT;
import static calculator.exception.util.NumberExtractorErrorMessage.INVALID_CHARACTER;
import static calculator.exception.util.NumberExtractorErrorMessage.NEGATIVE_OR_ZERO_NUMBER;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {

    @Test
    @DisplayName("기본 구분자를 사용한 문자열 덧셈 테스트")
    void 기본_구분자_덧셈_테스트() {
        // given
        String input = "1,2:3";
        Calculator calculator = new Calculator(input);

        // when
        int result = calculator.calculate();

        // then
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("커스텀 구분자를 사용한 문자열 덧셈 테스트")
    void 커스텀_구분자_덧셈_테스트() {
        // given
        String input = "//;\\n1;2;3";
        Calculator calculator = new Calculator(input);

        // when
        int result = calculator.calculate();

        // then
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("빈 문자열 입력 시 결과는 0")
    void 빈_문자열_입력_테스트() {
        // given
        String input = "";
        Calculator calculator = new Calculator(input);

        // when
        int result = calculator.calculate();

        // then
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("0 또는 음수 포함 시 예외 발생")
    void 음수_또는_0_포함된_문자열_예외_테스트() {
        // given
        String input = "1,-2:3";
        Calculator calculator = new Calculator(input);

        // when & then
        assertThatThrownBy(calculator::calculate)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NEGATIVE_OR_ZERO_NUMBER.getMessage());
    }

    @Test
    @DisplayName("숫자가 아닌 문자 포함 시 예외 발생")
    void 숫자가_아닌_문자_포함된_문자열_예외_테스트() {
        // given
        String input = "1,2:abc";
        Calculator calculator = new Calculator(input);

        // when & then
        assertThatThrownBy(calculator::calculate)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_CHARACTER.getMessage());
    }

    @Test
    @DisplayName("정수가 아닌 숫자가 포함된 문자열 처리")
    void 정수가_아닌_숫자_포함된_문자열_예외_테스트() {
        // given
        String input = "1.5,2:3";
        Calculator calculator = new Calculator(input);

        // when & then
        assertThatThrownBy(calculator::calculate)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_CHARACTER.getMessage());
    }

    @Test
    @DisplayName("커스텀 구분자가 올바르지 않은 형식일 경우 예외 발생")
    void 잘못된_형식의_커스텀_구분자_예외_테스트() {
        // given
        String input = "//n1,2:3";
        Calculator calculator = new Calculator(input);

        // when & then
        assertThatThrownBy(calculator::calculate)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_CUSTOM_DELIMITER_FORMAT.getMessage());
    }

    @Test
    @DisplayName("메타 기호 구분자를 사용하는 문자열 예외 처리")
    void 메타_기호_커스텀_구분자를_포함한_문자열() {
        // given
        String input = "//?\\n1?2?3";
        Calculator calculator = new Calculator(input);

        // when & then
        assertThatThrownBy(calculator::calculate)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_CUSTOM_DELIMITER_FORMAT.getMessage());
    }

    @Test
    @DisplayName("커스텀 구분자가 길 경우 정상 동작")
    void 긴_커스텀_구분자_입력_테스트() {
        // given
        String input = "//;;;\\n1;;;2;;;3";

        // when
        int result = new Calculator(input).calculate();

        // then
        assertThat(result).isEqualTo(6);
    }
}