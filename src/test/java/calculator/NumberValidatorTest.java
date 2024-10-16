package calculator;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class NumberValidatorTest {

    @Test
    void 음수_검증_테스트() {
        NumberValidator validator = new NumberValidator();
        assertThrows(IllegalArgumentException.class, () ->
                validator.NegativeOrZeroCheck(new String[]{"-1", "2", "3"}));
    }

    @Test
    void zero_검증_테스트() {
        NumberValidator validator = new NumberValidator();
        assertThrows(IllegalArgumentException.class, () ->
                validator.NegativeOrZeroCheck(new String[]{"0", "2", "3"}));
    }
}