package calculatorAddTest;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class NumberValidatorTest {

    @Test
    void 음수_검증_테스트() {
        NumberValidator validator = new NumberValidator();
        assertThrows(IllegalArgumentException.class, () ->
                validator.positiveNumberCheck(new String[]{"-1", "2", "3"}));
    }

    @Test
    void zero_검증_테스트() {
        NumberValidator validator = new NumberValidator();
        assertThrows(IllegalArgumentException.class, () ->
                validator.positiveNumberCheck(new String[]{"0", "2", "3"}));
    }

    @Test
    void 알파벳_검증_테스트() {
        NumberValidator validator = new NumberValidator();
        assertThrows(IllegalArgumentException.class, () ->
                validator.positiveNumberCheck(new String[]{"a", "2", "3"}));
    }

    @Test
    void 공백_검증_테스트() {
        NumberValidator validator = new NumberValidator();
        assertThrows(IllegalArgumentException.class, () ->
                validator.positiveNumberCheck(new String[]{"1 ", "2", "3"}));
    }

    @Test
    void 숫자_문자_혼합_테스트() {
        NumberValidator validator = new NumberValidator();
        assertThrows(IllegalArgumentException.class, () ->
                validator.positiveNumberCheck(new String[]{"a1", "b2", "c3"}));
    }
}