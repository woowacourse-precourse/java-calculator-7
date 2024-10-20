package calculator;

import calculator.controller.CalculatorController;
import calculator.domain.Separator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SumCalculatorTest {
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

        Exception exception = assertThrows(IllegalArgumentException.class, () -> calculatorController.run(input));

        assertEquals("유효하지 않은 형식입니다: a", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionForNegativeNumbersWithCustomSeparator() {
        // 커스텀 구분자가 있고, 입력에 음수가 있을 때
        String input = "//;\\n1;-2;3";

        Exception exception = assertThrows(IllegalArgumentException.class, () -> calculatorController.run(input));

        assertEquals("양수만 허용됩니다: -2", exception.getMessage());
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

        Exception exception = assertThrows(IllegalArgumentException.class, () -> calculatorController.run(input));

        assertEquals("유효하지 않은 형식입니다: a", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionForNegativeNumbersWithoutCustomSeparator() {
        // 커스텀 구분자가 없고, 입력에 음수가 있을 때
        String input = "1,-2,3";

        Exception exception = assertThrows(IllegalArgumentException.class, () -> calculatorController.run(input));

        assertEquals("양수만 허용됩니다: -2", exception.getMessage());
    }
}
