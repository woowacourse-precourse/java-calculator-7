package calculator.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputValidatorTest {

    private final InputValidator inputValidator = new InputValidator();

    @Test
    @DisplayName("입력값의 유효성 검증 - 검증 성공")
    void validateInputFormat() {
        //given
        String input = "//;\\n1,2:3";

        //when
        //then
        Assertions.assertDoesNotThrow(() -> inputValidator.validateInputFormat(input));
    }

    @Test
    @DisplayName("입력값의 유효성 검증 - 여러 커스텀 구분자를 입력한 경우")
    void validateInputFormatWithMultipleCustomDelimiter() {
        //given
        String input = "//;;\\n1,2:3";

        //when
        //then
        Assertions.assertThrows(IllegalArgumentException.class, () -> inputValidator.validateInputFormat(input));
    }

    @Test
    @DisplayName("입력값의 유효성 검증 - //로 시작하나, \\n이 나오지 않는 경우")
    void validateInputFormatWithWrongFormatDelimiter() {
        //given
        String input = "//;1,2:3";

        //when
        //then
        Assertions.assertThrows(IllegalArgumentException.class, () -> inputValidator.validateInputFormat(input));
    }

    @Test
    @DisplayName("입력값의 유효성 검증 - 정상 문자열이 여러번 나오는 경우")
    void validateInputFormatWithMultipleValidInput() {
        //given
        String input = "//;\\n1,2:3//;\\n1,2:3";

        //when
        //then
        Assertions.assertThrows(IllegalArgumentException.class, () -> inputValidator.validateInputFormat(input));
    }
}