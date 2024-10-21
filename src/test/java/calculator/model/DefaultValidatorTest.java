package calculator.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
}