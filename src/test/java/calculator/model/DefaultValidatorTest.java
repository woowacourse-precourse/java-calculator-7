package calculator.model;

import calculator.constant.ErrorMessages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DefaultValidatorTest {

    @Test
    @DisplayName("정상적인 기본 구분자 문자열 입력시 validate 정상 실행된다.")
    void 유효한_기본_구분자_문자열_검증() {
        // given
        String validDefaultString = "1,2:3";

        // when
        ParsedInput parsedInput = new DefaultValidator().validate(validDefaultString);

        //then
        assertEquals(parsedInput.getNumbersWithDelimiter(), validDefaultString);
    }

    @Test
    @DisplayName("구분자 사이에 빈 문자열이 들어가도 정상 실행된다.")
    void 구분자_사이_빈_문자열_검증() {
        String inputString1 = "";

        ParsedInput result1 = new DefaultValidator().validate(inputString1);

        assertEquals(result1.getNumbersWithDelimiter(), inputString1);

        String inputString2 = "1:,,2";

        ParsedInput result2 = new DefaultValidator().validate(inputString2);

        assertEquals(result2.getNumbersWithDelimiter(), inputString2);
    }

    @Test
    @DisplayName("음수 입력시 예외를 던진다.")
    void 음수_검증() {
        String inputString = "1,-2,3";

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> new DefaultValidator().validate(inputString));

        assertEquals(e.getMessage(), ErrorMessages.NEGATIVE_NUMBER_NOT_ALLOWED);
    }

    @Test
    @DisplayName("숫자 검증시 실수도 예외를 던진다.")
    void 실수_검증() {
        String inputString = "1.1,2.2,3";

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> new DefaultValidator().validate(inputString));

        assertEquals(e.getMessage(), ErrorMessages.INVALID_NUMBER_FORMAT);
    }

    @Test
    @DisplayName("유효하지 않는 구분자 입력에 대해서 예외를 던진다.")
    void 비정상_입력_검증() {
        String inputString = "1*1,2;2,3";

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> new DefaultValidator().validate(inputString));

        assertEquals(e.getMessage(), ErrorMessages.INVALID_NUMBER_FORMAT);
    }

}