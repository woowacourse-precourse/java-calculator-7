package calculator.util;

import calculator.exception.util.InputValidateErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static calculator.exception.util.InputValidateErrorMessage.INVALID_INPUT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputValidatorTest {

    @Test
    @DisplayName("정상적인 문자열 입력")
    void 정상적인_문자열_입력() {
        // given
        String input = "3:4,2";

        // when
        String result = InputValidator.validate(input);

        // then
        assertThat(result).isEqualTo(input);
    }

    @Test
    @DisplayName("빈 문자열 입력 시 0 반환")
    void 빈_문자열_입력() {
        // given
        String input = "";

        // when
        String result = InputValidator.validate(input);

        // then
        assertThat(result).isEqualTo("0");
    }

    @Test
    @DisplayName("// 또는 숫자로 시작하지 않는다면 예외 처리")
    void 올바르지_않은_문자열_입력_1() {
        // given
        String input = "?3,4";

        // when & then
        assertThatThrownBy(() -> InputValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(InputValidateErrorMessage.INVALID_INPUT.getMessage());
    }

    @Test
    @DisplayName("// 또는 숫자로 시작하지 않는다면 예외 처리")
    void 올바르지_않은_문자열_입력_2() {
        // given
        String input = ":3,4";

        // when & then
        assertThatThrownBy(() -> InputValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(InputValidateErrorMessage.INVALID_INPUT.getMessage());
    }

    @Test
    @DisplayName("마지막에 숫자가 없을 경우")
    void 마지막에_숫자가_없을_경우_1() {
        // given
        String input = "13:34:2:::::";

        // when & then
        assertThatThrownBy(() -> InputValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(InputValidateErrorMessage.INVALID_INPUT.getMessage());
    }

    @Test
    @DisplayName("마지막에 숫자가 없을 경우")
    void 마지막에_숫자가_없을_경우_2() {
        // given
        String input = "13:34:2:";
        String[] delimiters = {",", ":", "&"};

        // when & then
        assertThatThrownBy(() -> InputValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(InputValidateErrorMessage.INVALID_INPUT.getMessage());
    }

    @Test
    @DisplayName("마지막에 숫자가 없을 경우")
    void 마지막에_숫자가_없을_경우_3() {
        // given
        String input = "13:34:2&";
        String[] delimiters = {",", ":", "&"};

        // when & then
        assertThatThrownBy(() -> InputValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(InputValidateErrorMessage.INVALID_INPUT.getMessage());
    }
}