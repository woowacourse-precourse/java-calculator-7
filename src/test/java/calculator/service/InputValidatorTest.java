package calculator.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputValidatorTest {

    private InputValidator validator;

    @BeforeEach
    void setUp() {
        validator = new InputValidator();
    }

    @Test
    @DisplayName("기본 구분자만 사용하였을 경우 예외가 발생하지 않는다.")
    void validateUsingBasicDelimiter() {
        String input = "1,2:3";

        assertDoesNotThrow(() -> validator.validate(input));
    }

    @Test
    @DisplayName("사용할 수 있는 커스텀 구분자를 사용하였을 경우 예외가 발생하지 않는다.")
    void validateCustomDelimiter() {
        String input = "//;\\n1;2;3";

        assertDoesNotThrow(() -> validator.validate(input));
    }

    @Test
    @DisplayName("구분자가 존재하지 않을 경우 예외가 발생한다.")
    void notingDelimiterException() {
        String input = "123";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            validator.validate(input);
        });

        assertEquals("기본 구분자가 포함되어 있지 않습니다.", exception.getMessage());
    }

    @Test
    @DisplayName("커스텀 구분자의 형식이 아닐 경우 예외가 발생한다.")
    void customDelimiterFormatException() {
        String input = "//1,3,4";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            validator.validate(input);
        });

        assertEquals("커스텀 구분자를 사용하기 위한 형식이 아닙니다.", exception.getMessage());
    }

    @Test
    @DisplayName("커스텀 구분자에 사용할 수 없는 구분자를 사용하였을 경우 예외가 발생한다.")
    void invalidCustomDelimiterException() {
        String input = "//\\n\\n1\\n2\\n3";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            validator.validate(input);
        });

        assertEquals("사용할 수 없는 구분자가 포함되어있습니다.", exception.getMessage());
    }

}
