package calculator.validator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CalculatorValidatorTest {

    private CalculatorValidator validator;

    @BeforeEach
    void 초기화() {
        validator = new CalculatorValidator();
    }

    @Test
    void 구분자_유효성_검증_성공() {
        String input = "//;\n1;2;3";
        assertThatCode(() -> validator.validateSeparator(input))
                .doesNotThrowAnyException();
    }

    @Test
    void 구분자_유효성_검증_실패_선언부없음() {
        String input = "//;";
        assertThatThrownBy(() -> validator.validateSeparator(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구분자_유효성_검증_구분자_길이_초과() {
        String input = "//;;\n1;2;3";
        assertThatThrownBy(() -> validator.validateSeparator(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자_형식_유효성_검증_실패() {
        String number = "a1";
        assertThatThrownBy(() -> validator.validateNumberFormat(number))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 음수_유효성_검증_성공() {
        int number = 6;
        assertThatCode(() -> validator.validateNonNegative(number))
                .doesNotThrowAnyException();
    }

    @Test
    void 음수_유효성_검증_실패() {
        int number = -5;
        assertThatThrownBy(() -> validator.validateNonNegative(number))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
