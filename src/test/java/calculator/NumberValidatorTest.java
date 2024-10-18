package calculator;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NumberValidatorTest {

    private NumberValidator validator;

    @BeforeEach
    void setUp() {
        validator = new NumberValidator();
    }

    @Test
    void 음수_예외처리() {
        assertThrows(IllegalArgumentException.class, () ->
                validator.positiveNumberCheck(new String[]{"-1", "2", "3"}));
    }

    @Test
    void zero_예외처리() {
        assertThrows(IllegalArgumentException.class, () ->
                validator.positiveNumberCheck(new String[]{"0", "2", "3"}));
    }

    @Test
    void 문자_예외처리() {
        assertThrows(IllegalArgumentException.class, () ->
                validator.positiveNumberCheck(new String[]{"a", "ㅁ", "a3"}));
    }

    @Test
    void 공백_예외처리() {
        assertThrows(IllegalArgumentException.class, () ->
                validator.positiveNumberCheck(new String[]{" 1 ", "2", "3"}));
    }
}