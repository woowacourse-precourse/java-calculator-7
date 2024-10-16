package calculator;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

class ValidatorTest {
    Validator validator = new Validator();

    @Test
    void 커스텀_구분자의_포맷이_올바르면_True_반환() {
        assertTrue(validator.hasCustomSeparator("//;\n1;2;3"));
    }

    @Test
    void 커스텀_구분자가_없다면_False_반환() {
        assertFalse(validator.hasCustomSeparator("1:2:3"));
    }

    @Test
    void 숫자로_시작한다면_True_반환() {
        assertTrue(validator.isStartWithDigit("1;2;3"));
    }

    @Test
    void 숫자로_시작하지_않으면_False_반환() {
        assertFalse(validator.isStartWithDigit("//;\n"));
    }
}