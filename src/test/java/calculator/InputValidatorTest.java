package calculator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import calculator.delimiter.CustomDelimiterPattern;
import calculator.delimiter.DefaultDelimiterPattern;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class InputValidatorTest {
    private static final String validateErrorMessage = "문자열 입력 유효성 검사에 실패하였습니다.";
    private static InputValidator validator;

    @BeforeAll
    static void beforeAll() {
        validator = new InputValidator(List.of(new CustomDelimiterPattern(), new DefaultDelimiterPattern()));
    }

    @Test
    void 유효한_입력일때_예외를_던지지_않는다() {
        assertDoesNotThrow(() -> validator.validate("1,2,3"));
    }

    @Test
    void 유효한_입력이_아닐때_예외를_던진다() {
        assertThatThrownBy(() -> validator.validate("1:"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(validateErrorMessage);
    }
}
