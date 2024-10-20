package calculator;

import calculator.InputValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputValidatorTest {

    @Test
    void 양수가아닌값(){
        String token = "-1";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.validateParseInt(token);
        });
        assertEquals("입력된 숫자는 0보다 커야 합니다.", exception.getMessage());
    }


    @Test
    void 숫자가아닌값() {
        String token = "a";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.validateParseInt(token);
        });
        assertEquals("입력된 값이 숫자 형식이 아닙니다.", exception.getMessage());
    }

    @Test
    void 커스텀_지정양식_오류() {
        int delimiterEndIdx = -1;  // "\n"이 없다고 가정
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.validateFormat(delimiterEndIdx);
        });
        assertEquals("커스텀 구분자 지정 형식이 잘못되었습니다.", exception.getMessage());
    }

    @Test
    void 커스텀_구분자_오류() {
        String customDelimiter = "?!"; // 구분자가 "문자"가 아니라고 가정
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.validateDelimiter(customDelimiter);
        });
        assertEquals("커스텀 구분자는 하나의 문자여야 합니다.", exception.getMessage());
    }

    @Test
    void 커스텀_구분자_공백_오류() {
        String customDelimiter = ""; // 구분자가 "문자"가 아니라고 가정
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.validateDelimiter(customDelimiter);
        });
        assertEquals("커스텀 구분자는 하나의 문자여야 합니다.", exception.getMessage());
    }

    @Test
    void 커스텀_구분자_숫자_오류() {
        String customDelimiter = "1"; // 구분자가 숫자
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.validateDelimiter(customDelimiter);
        });
        assertEquals("커스텀 구분자는 숫자가 될 수 없습니다.", exception.getMessage());
    }
}