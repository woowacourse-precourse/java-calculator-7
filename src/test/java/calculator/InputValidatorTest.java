package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import calculator.CalculationManager.Validator;
import org.junit.jupiter.api.Test;

public class InputValidatorTest {
    private final Validator validator = new InputValidator();

    @Test
    public void testValidInput() {
        validator.validate("1,2");
        validator.validate("//;\\n1;2;3");
        validator.validate("//-\\n1-2-3-4");
    }

    @Test
    public void testInvalidStart() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            validator.validate("!1,2");
        });
        assertEquals("입력은 숫자 또는 '//'로 시작해야 합니다.", exception.getMessage());
    }

    @Test
    public void testNegativeNumber() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            validator.validate("//>\\n1>-2>5");
        });
        assertEquals("음수가 사용되었습니다.", exception.getMessage());
    }

    @Test
    public void testInvalidCustomDelimiter() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            validator.validate("//;\\n1;2;3;");
        });
        assertEquals("입력의 마지막에 구분자가 사용되었습니다.", exception.getMessage());
    }

    @Test
    public void testConsecutiveDelimiters() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            validator.validate("//;\\n1;;2");
        });
        assertEquals("숫자가 아닌 문자가 포함되었습니다.", exception.getMessage());
    }
}

