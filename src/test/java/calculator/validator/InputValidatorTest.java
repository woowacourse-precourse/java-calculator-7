package calculator.validator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class InputValidatorTest {

    @Test
    void 기본_구분자_정상_입력시_예외가_발생하지_않는다() {
        String input = "1,2:3";
        assertDoesNotThrow(() -> InputValidator.validateInput(input, false, null));
    }

    @Test
    void 문자열의_시작이_숫자가_아니면_예외가_발생한다() {
        String input = ",1,2:3";
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateInput(input, false, null));
    }

    @Test
    void 문자열의_시작이_숫자가_아니면_예외가_발생한다2() {
        String input = "//;\\n;3;4;5";
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateInput(input, true, ";"));
    }

    @Test
    void 연속된_구분자가_나오면_예외가_발생한다() {
        String input = "1,,2:3";
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateInput(input, false, null));
    }

    @Test
    void 음수_입력시_예외가_발생한다() {
        String input = "1,-2,3";
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateInput(input, false, null));
    }

    @Test
    void 커스텀_구분자_정상_입력시_예외가_발생하지_않는다() {
        String input = "//;\\n1;2;3";
        assertDoesNotThrow(() -> InputValidator.validateInput(input, true, ";"));
    }

    @Test
    void 커스텀_구분자_연속_입력시_예외가_발생한다() {
        String input = "//;\\n1;;2;3";
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateInput(input, true, ";"));
    }
}
