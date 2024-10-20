package calculator;

import calculator.domain.InputValidator;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class InputValidatorServiceTest {
    @Test
    void shouldThrowExceptionForNonIntegerValues() {
        InputValidator inputValidator = new InputValidator();
        List<String> input = Arrays.asList("1", "2", "a", "4");

        // 정수가 아닌 값("a")이 있을 때 예외가 발생하는지 확인
        Exception exception = assertThrows(IllegalArgumentException.class, () -> inputValidator.validate(input));
        assertEquals("유효하지 않은 형식입니다: a", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionForNegativeValues() {
        InputValidator inputValidator = new InputValidator();
        List<String> input = Arrays.asList("1", "-2", "3");

        // 음수 값("-2")이 있을 때 예외가 발생하는지 확인
        Exception exception = assertThrows(IllegalArgumentException.class, () -> inputValidator.validate(input));
        assertEquals("양수만 허용됩니다: -2", exception.getMessage());
    }

    @Test
    void shouldPassForValidPositiveIntegers() {
        InputValidator inputValidator = new InputValidator();
        List<String> input = Arrays.asList("1", "2", "3", "4");

        // 모두 양수일 때는 예외가 발생하지 않아야 함
        assertDoesNotThrow(() -> inputValidator.validate(input));
    }
}
