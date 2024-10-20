package calculator;

import static calculator.exception.Exception.INVALID_NEGATIVE_NUMBER;
import static calculator.exception.Exception.INVALID_NUMBER_FORMAT;
import static org.junit.jupiter.api.Assertions.*;

import calculator.controller.CalculatorController;
import calculator.domain.Separator;
import org.junit.jupiter.api.Test;

class CalculatorControllerTest {
    Separator separator = new Separator();
    CalculatorController calculatorController = new CalculatorController(separator);

    @Test
    void shouldReturnSumWithCustomSeparatorAndValidInput() {
        // 커스텀 구분자가 있고, 올바른 형식의 입력일 때
        String input = "//;\\n1;2;3";

        int result = calculatorController.run(input);

        assertEquals(6, result, "합계는 6이어야 합니다.");
    }

    @Test
    void shouldThrowExceptionForInvalidCharacterWithCustomSeparator() {
        // 커스텀 구분자가 있고, 입력에 문자가 있을 때
        String input = "//;\\n1;2;a";

        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                calculatorController.run(input));

        assertEquals(INVALID_NUMBER_FORMAT.getMessage() + "a", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionForNegativeNumbersWithCustomSeparator() {
        // 커스텀 구분자가 있고, 입력에 음수가 있을 때
        String input = "//;\\n1;-2;3";

        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                calculatorController.run(input));

        assertEquals(INVALID_NEGATIVE_NUMBER.getMessage() + "-2", exception.getMessage());
    }

    @Test
    void shouldReturnSumWithoutCustomSeparatorAndValidInput() {
        // 커스텀 구분자가 없고, 올바른 형식의 입력일 때
        String input = "1,2:3";

        int result = calculatorController.run(input);

        assertEquals(6, result, "합계는 6이어야 합니다.");
    }

    @Test
    void shouldThrowExceptionForInvalidCharacterWithoutCustomSeparator() {
        // 커스텀 구분자가 없고, 입력에 문자가 있을 때
        String input = "1,2,a";

        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                calculatorController.run(input));

        assertEquals(INVALID_NUMBER_FORMAT.getMessage() + "a", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionForNegativeNumbersWithoutCustomSeparator() {
        // 커스텀 구분자가 없고, 입력에 음수가 있을 때
        String input = "1,-2,3";

        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                calculatorController.run(input));

        assertEquals(INVALID_NEGATIVE_NUMBER.getMessage() + "-2", exception.getMessage());
    }
}
