package calculator;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class NumberTest {

    @Test
    void 음수_예외처리() {
        assertThrows(IllegalArgumentException.class, () ->
                new Number("-1"));
    }

    @Test
    void zero_예외처리() {
        assertThrows(IllegalArgumentException.class, () ->
                new Number("0"));
    }

    @Test
    void 문자_예외처리() {
        assertThrows(IllegalArgumentException.class, () ->
                new Number("a"));
        assertThrows(IllegalArgumentException.class, () ->
                new Number("ㅁ"));
    }
}