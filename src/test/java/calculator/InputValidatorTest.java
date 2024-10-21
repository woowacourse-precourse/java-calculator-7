package calculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class InputValidatorTest {
    private static InputValidator inputValidator = new InputValidator();

    @Test
    void 커스텀_구분자() {
        String s = "//.\n3,6";
        assertDoesNotThrow(()->inputValidator.validate(s));
    }

    @Test
    void 커스텀_구분자_2() {
        String s = "//}\n3}6";
        assertDoesNotThrow(()->inputValidator.validate(s));
    }

    @Test
    void 기본_구분자() {
        String s = "3,6;4";
        assertDoesNotThrow(()->inputValidator.validate(s));
    }

    @Test
    void 잘못된_유형의_입력() {
        String s = "//3,6;4";
        assertThrowsExactly(IllegalArgumentException.class, () -> inputValidator.validate(s));
    }

    @Test
    void 음수_입력() {
        String s = "-3,6;4";
        assertThrowsExactly(IllegalArgumentException.class, () -> inputValidator.validate(s));
    }
}