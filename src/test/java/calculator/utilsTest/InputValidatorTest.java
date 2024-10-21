package calculator.utilsTest;

import calculator.exception.CalculatorException;
import calculator.utils.InputValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InputValidatorTest {
    @Test
    public void testNegativeIntegerInput_ThrowsException() {
        // 음수가 포함된 입력에 대한 테스트 (예외 발생)
        String input = "1,-2,3";

        assertThrows(CalculatorException.class, () -> {
            InputValidator.validateInput(input);
        }, "INVALID_NEGATIVE_INTEGER 예외가 발생해야 합니다.");
    }

    @Test
    public void testCustomDelimiterWithValidInput_NoException() {
        // 유효한 커스텀 구분자와 수식 (예외 없음)
        String input = "//;\\n1;2;3";

        assertDoesNotThrow(() -> {
            InputValidator.validateInput(input);
        }, "예외가 발생하지 않아야 합니다.");
    }

    @Test
    public void testCustomDelimiterWithInvalidNumber_ThrowsException() {
        // 커스텀 구분자 안에 음수 숫자가 있는 경우 (예외 발생)
        String input = "//;\n1;-2;3";

        assertThrows(CalculatorException.class, () -> {
            InputValidator.validateInput(input);
        }, "INVALID_CUSTOM_DELIMITER_INTEGER 예외가 발생해야 합니다.");
    }

    @Test
    public void testCustomDelimiterWithInvalidDelimiter_ThrowsException() {
        // 커스텀 구분자 외에 다른 구분자가 사용된 경우 (예외 발생)
        String input = "//;\\n1;2,3"; // 쉼표(,)는 잘못된 구분자

        assertThrows(CalculatorException.class, () -> {
            InputValidator.validateInput(input);
        }, "INVALID_CUSTOM_DELIMITER_EXPRESSION 예외가 발생해야 합니다.");
    }

    @Test
    public void testDefaultDelimiterWithValidInput_NoException() {
        // 유효한 기본 구분자와 수식 (예외 없음)
        String input = "1,2:3";

        assertDoesNotThrow(() -> {
            InputValidator.validateInput(input);
        }, "예외가 발생하지 않아야 합니다.");
    }

    @Test
    public void testDefaultDelimiterWithInvalidInput_ThrowsException() {
        // 기본 구분자와 수식에 잘못된 문자가 포함된 경우 (예외 발생)
        String input = "1,2;3"; // 세미콜론은 기본 구분자 형식에 맞지 않음

        assertThrows(CalculatorException.class, () -> {
            InputValidator.validateInput(input);
        }, "INVALID_DEFAULT_DELIMITER_EXPRESSION 예외가 발생해야 합니다.");
    }
}
