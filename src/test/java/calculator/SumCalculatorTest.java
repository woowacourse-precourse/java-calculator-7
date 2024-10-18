package calculator;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SumCalculatorTest {
    NumberValidator validator = new NumberValidator();
    StringConverter converter = new StringConverter(validator);
    SeparatorManager separator = new SeparatorManager();
    StringSplitter splitter = new StringSplitter(separator);
    SumCalculator calculator = new SumCalculator(splitter, converter, separator);

    @Test
    void shouldReturnSumWithCustomSeparatorAndValidInput() {
        // 커스텀 구분자가 있고, 올바른 형식의 입력일 때
        String input = "//;\\n1;2;3";

        int result = calculator.sum(input);

        assertEquals(6, result, "합계는 6이어야 합니다.");
    }

    @Test
    void shouldThrowExceptionForInvalidCharacterWithCustomSeparator() {
        // 커스텀 구분자가 있고, 입력에 문자가 있을 때
        String input = "//;\\n1;2;a";

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.sum(input);
        });

        assertEquals("유효하지 않은 형식입니다: a", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionForNegativeNumbersWithCustomSeparator() {
        // 커스텀 구분자가 있고, 입력에 음수가 있을 때
        String input = "//;\\n1;-2;3";

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.sum(input);
        });

        assertEquals("양수만 허용됩니다: -2", exception.getMessage());
    }

    @Test
    void shouldReturnSumWithoutCustomSeparatorAndValidInput() {
        // 커스텀 구분자가 없고, 올바른 형식의 입력일 때
        String input = "1,2:3";

        int result = calculator.sum(input);

        assertEquals(6, result, "합계는 6이어야 합니다.");
    }

    @Test
    void shouldThrowExceptionForInvalidCharacterWithoutCustomSeparator() {
        // 커스텀 구분자가 없고, 입력에 문자가 있을 때
        String input = "1,2,a";

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.sum(input);
        });

        assertEquals("유효하지 않은 형식입니다: a", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionForNegativeNumbersWithoutCustomSeparator() {
        // 커스텀 구분자가 없고, 입력에 음수가 있을 때
        String input = "1,-2,3";

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.sum(input);
        });

        assertEquals("양수만 허용됩니다: -2", exception.getMessage());
    }
}
