package calculator.validator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static calculator.utils.CalculatorConstants.*;
import static calculator.utils.ErrorConstants.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidatorTest {

    Validator validator = new Validator(DELIMITER_REGEX, CUSTOM_DELIMITER_PREFIX, CUSTOM_DELIMITER_SUFFIX);

    @ParameterizedTest
    @ValueSource(strings = {"//\1", "//\n", "/\n"})
    void 커스텀_구분자_형식이_올바르지_않으면_예외를_던진다(String value) {
        assertThatThrownBy(() -> validator.validateDelimiter(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_INVALID_FORMAT);
    }

    @ParameterizedTest
    @ValueSource(strings = {"//1\\n", "//a\\n", "//-\\n", "// \\n"})
    void 커스텀_구분자가_올바르지_않으면_예외를_던진다(String value) {
        assertThatThrownBy(() -> validator.validateDelimiter(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_INVALID_DELIMITER);
    }

    @Test
    void 숫자가_공백일때_예외를_던진다() {
        String value = "1, ,3";
        assertThatThrownBy(() -> validator.validateDelimiter(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_NUMBER_EMPTY);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1+2", "//+\\n1_"})
    void 구분자가_아닌_문자가_있을경우_예외를_던진다(String value) {
        assertThatThrownBy(() -> validator.validateDelimiter(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_DELIMITER_NOT_EXIST);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,a,3", "//;\\na"})
    void 숫자_입력란예_영어가_있을경우_예외를_던진다(String value) {
        assertThatThrownBy(() -> validator.validateDelimiter(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_LETTERS_NOT_ALLOWED);
    }

    @ParameterizedTest
    @ValueSource(strings = {"//,\\n", "//:\\n"})
    void 커스텀_구분자가_중복이_있을경우_예외를_던진다(String value) {
        assertThatThrownBy(() -> validator.validateDelimiter(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_DELIMITER_DUPLICATE);
    }

}
