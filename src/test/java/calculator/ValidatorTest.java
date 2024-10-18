package calculator;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @Test
    void 올바른_포맷일때_아무_처리도_하지_않음() {
        String[] testCases = {"//@\n1@2@3", " ", "", "//@\n", "1:2:3"};
        for (String testCase : testCases) {
            assertDoesNotThrow(() -> validator.validateInput(testCase));
        }
    }

    @Test
    void 잘못된_포맷은_예외_발생() {
        String[] testCases = {"1@2@3//@\n", "\n@//1,2,3", "abc"};
        for (String testCase : testCases) {
            assertThatThrownBy(() -> validator.validateInput(testCase))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}