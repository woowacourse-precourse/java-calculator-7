package calculator.validators;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DelimiterValidatorTest {

    @Test
    @DisplayName("validateDelimiterFormat - 커스텀 구분자가 없을 경우 정상 동작한다.")
    void noCustomDelimiter() {
        // given
        String input = "1;2;3";
        // when & then
        assertDoesNotThrow(() -> DelimiterValidator.validateDelimiterFormat(input));
    }

    @Test
    @DisplayName("validateDelimiterFormat - 커스텀 구분자가 정상적으로 입력된 경우 정상 동작한다.")
    void successCustomDelimiter() {
        // given
        String input = "//,;[\\n1;2;3";
        // when & then
        assertDoesNotThrow(() -> DelimiterValidator.validateDelimiterFormat(input));
    }

    @Test
    @DisplayName("validateDelimiterFormat - 커스텀 구분자 입력시 '//'가 첫번째에 없으면 예외가 발생한다.")
    void failCustomDelimiter1() {
        // given
        String input = "\\n,//;[//n1;2;3";
        // when & then
        assertThrows(IllegalArgumentException.class, () -> DelimiterValidator.validateDelimiterFormat(input));
    }

    @Test
    @DisplayName("validateDelimiterFormat - 커스텀 구분자 입력시 '//'만 있으면 예외가 발생한다.")
    void failCustomDelimiter2() {
        // given
        String input = "//,;[//n1;2;3";
        // when & then
        assertThrows(IllegalArgumentException.class, () -> DelimiterValidator.validateDelimiterFormat(input));
    }

    @Test
    @DisplayName("validateDelimiterFormat - 커스텀 구분자 입력시 '\n'만 있으면 예외가 발생한다.")
    void failCustomDelimiter3() {
        // given
        String input = "\\n;;1;2;3";
        // when & then
        assertThrows(IllegalArgumentException.class, () -> DelimiterValidator.validateDelimiterFormat(input));
    }

}