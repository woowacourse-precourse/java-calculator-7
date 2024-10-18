package calculator.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    void 빈문자열_테스트() {
        assertEquals("0", calculator.add(""));
    }

    @Test
    void 기본구분자_테스트() {
        assertEquals("6", calculator.add("1,2:3"));
    }

    @Test
    void 커스텀구분자_단일_테스트() {
        assertEquals("6", calculator.add("//;\n1;2;3"));
    }

    @Test
    void 커스텀구분자_다중_테스트() {
        assertEquals("6", calculator.add("//*%\n1*2%3"));
    }

    @Test
    void 음수_입력_예외_테스트() {
        assertThrows(IllegalArgumentException.class, () -> calculator.add("-1,2,3"));
    }

    @Test
    void 숫자가_아닌_입력_예외_테스트() {
        assertThrows(IllegalArgumentException.class, () -> calculator.add("1,2,문자열"));
    }
}
