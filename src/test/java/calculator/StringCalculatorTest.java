package calculator;

import calculator.controller.MainController;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {

    @Test
    void shouldReturnSumWithCustomSeparatorAndValidInput() {
        MainController mainController = new MainController();

        // 커스텀 구분자와 올바른 입력이 있을 때
        String input = "//;\\n1;2;3";

        mainController.runWithInput(input);
    }

    @Test
    void shouldThrowExceptionForInvalidCharacterWithCustomSeparator() {
        MainController mainController = new MainController();

        // 커스텀 구분자와 문자가 포함된 입력이 있을 때
        String input = "//;\\n1;2;a";

        // IllegalArgumentException이 발생해야 함
        Exception exception = assertThrows(IllegalArgumentException.class, () -> mainController.runWithInput(input));

        assertEquals("유효하지 않은 형식입니다: a", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionForNegativeNumbersWithCustomSeparator() {
        MainController mainController = new MainController();

        // 커스텀 구분자와 음수가 포함된 입력이 있을 때
        String input = "//;\\n1;-2;3";

        // IllegalArgumentException이 발생해야 함
        Exception exception = assertThrows(IllegalArgumentException.class, () -> mainController.runWithInput(input));

        assertEquals("양수만 허용됩니다: -2", exception.getMessage());
    }

    @Test
    void shouldReturnSumWithoutCustomSeparatorAndValidInput() {
        MainController mainController = new MainController();

        // 기본 구분자(쉼표, 콜론)와 올바른 입력이 있을 때
        String input = "1,2:3";

        mainController.runWithInput(input);
    }

    @Test
    void shouldThrowExceptionForInvalidCharacterWithoutCustomSeparator() {
        MainController mainController = new MainController();

        // 기본 구분자와 문자가 포함된 입력이 있을 때
        String input = "1,2,a";

        // IllegalArgumentException이 발생해야 함
        Exception exception = assertThrows(IllegalArgumentException.class, () -> mainController.runWithInput(input));

        assertEquals("유효하지 않은 형식입니다: a", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionForNegativeNumbersWithoutCustomSeparator() {
        MainController mainController = new MainController();

        // 기본 구분자와 음수가 포함된 입력이 있을 때
        String input = "1,-2,3";

        // IllegalArgumentException이 발생해야 함
        Exception exception = assertThrows(IllegalArgumentException.class, () -> mainController.runWithInput(input));

        assertEquals("양수만 허용됩니다: -2", exception.getMessage());
    }
}
