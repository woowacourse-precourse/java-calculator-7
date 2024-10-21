package calculator;

import static calculator.exception.Exception.INVALID_NEGATIVE_NUMBER;
import static calculator.exception.Exception.INVALID_NUMBER_FORMAT;
import static calculator.exception.Exception.INVALID_NUMBER_SIZE;
import static org.junit.jupiter.api.Assertions.*;

import calculator.domain.InputValidator;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class InputValidatorTest {
    @Test
    void shouldThrowExceptionForNonIntegerValues() {
        InputValidator inputValidator = new InputValidator();
        List<String> input = Arrays.asList("1", "2", "a", "4");

        // 정수가 아닌 값("a")이 있을 때 예외가 발생하는지 확인
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                inputValidator.validate(input));
        assertEquals(INVALID_NUMBER_FORMAT.getMessage() + "a", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionForNegativeValues() {
        InputValidator inputValidator = new InputValidator();
        List<String> input = Arrays.asList("1", "-2", "3");

        // 음수 값("-2")이 있을 때 예외가 발생하는지 확인
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                inputValidator.validate(input));
        assertEquals(INVALID_NEGATIVE_NUMBER.getMessage() + "-2", exception.getMessage());
    }

    @Test
    void shouldPassForValidPositiveIntegers() {
        InputValidator inputValidator = new InputValidator();
        List<String> input = Arrays.asList("1", "2", "3", "4");

        // 모두 양수일 때는 예외가 발생하지 않아야 함
        assertDoesNotThrow(() -> inputValidator.validate(input));
    }

    @Test
    void shouldThrowExceptionForIntegerOverflow() {
        InputValidator inputValidator = new InputValidator();
        // 정수 범위를 넘어서는 값
        List<String> input = Arrays.asList("1", "2147483648");

        // 정수 범위를 넘는 값이 있을 때 예외가 발생하는지 확인
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                inputValidator.validate(input));
        assertEquals(INVALID_NUMBER_SIZE.getMessage() + "2147483648", exception.getMessage());
    }
}
