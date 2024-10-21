package calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputValidationTest {
    private final InputValidation validator = new InputValidation();

    @Test
    public void testValidate_EmptyInput() {
        assertThrows(IllegalArgumentException.class, () -> {
            validator.validate("");
        });
    }

    @Test
    public void testValidate_CustomDelimiter() {
        assertDoesNotThrow(() -> {
            validator.validate("//;\n1;2;3");
        });
    }

    @Test
    public void testValidate_DefaultDelimiter() {
        assertDoesNotThrow(() -> {
            validator.validate("1,2:3");
        });
    }

    @Test
    public void testValidate_InvalidFormat() {
        assertThrows(IllegalArgumentException.class, () -> {
            validator.validate("wooteco123456789");
        });
    }

    @Test
    public void testValidate_InvalidCustomDelimiterFormat() {
        assertThrows(IllegalArgumentException.class, () -> {
            validator.validate("//;\\n"); // 숫자 없이 커스텀 구분자만 입력 시 예외처리
        });

        assertThrows(IllegalArgumentException.class, () -> {
            validator.validate("//;\\n1;2;3;"); // 입력 문자열 마지막에 구분자가 있을 때 예외처리
        });
    }

    @Test
    public void testValidate_EmptyChars() {
        assertThrows(IllegalArgumentException.class, () -> {
            validator.validate("1, 2, 3");  // 문자열 사이에 공백 있을 시
        });
    }

}