package calculator.domain.validator;

import static calculator.domain.constant.errorMessage.ParseError.INCORRECT_POSITION;
import static calculator.domain.constant.errorMessage.ParseError.INVALID_FORMAT;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputValidatorTest {

    private final InputValidator validator = new InputValidator();

    @Test
    @DisplayName("올바른 형식의 커스텀 구분자 입력은 통과한다")
    void validCustomDelimiterFormatShouldPass() {
        String input = "//;\\n1;2;3";
        validator.validateFormat(input);
    }

    @Test
    @DisplayName("구분자의 시작과 끝이 잘못된 위치에 있을 때 예외가 발생한다")
    void throwsExceptionForIncorrectDelimiterPosition() {
        String input = "1,2//;\n3";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> validator.validateFormat(input));

        assertEquals(INCORRECT_POSITION.getMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("구분자의 형식이 잘못되었을 때 예외가 발생한다")
    void throwsExceptionForInvalidDelimiterFormat() {
        String input = "//;;1,2,3";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> validator.validateFormat(input));

        assertEquals(INVALID_FORMAT.getMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("숫자 사이에 공백이 있으면 예외가 발생한다")
    void throwsExceptionForInternalWhitespace() {
        String token = "1 2";
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateNoInternalWhitespace(token));
    }


}
