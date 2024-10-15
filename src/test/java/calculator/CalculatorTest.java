package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    @DisplayName("빈 문자열이 입력되면 0을 반환한다.")
    @Test
    void testEmptyString() {
        Calculator calculator = new Calculator();
        assertEquals(0, calculator.add(""));
    }

    @DisplayName("잘못된 값을 입력할 경우 IllegalArgumentException을 발생시키고,"
        + " 프로그램을 종료한다.")
    @Test
    void testInvalidValue() {
        Calculator calculator = new Calculator();
        assertThrows(IllegalArgumentException.class, () ->
            calculator.add("-1,2,3"));
        assertThrows(IllegalArgumentException.class, () ->
            calculator.add("0,2,3"));
    }

    @DisplayName(",또는:을 기본 구분자로 사용하여 각 숫자를 더하여 합계를 반환한다.")
    @Test
    void sumNumbersSeparatedByDefaultSeparator() {
        Calculator calculator = new Calculator();
        assertEquals(6,calculator.add("1,2,3"));
        assertEquals(6,calculator.add("1:2:3"));
        assertEquals(6,calculator.add("1,2:3"));
    }

    @DisplayName("// \n 사이에 넣은 문자를 커스텀 구분자로 사용할 수 있게 한다.")
    @Test
    void sumNumbersSeparatedByCustomSeparator() {
        Calculator calculator = new Calculator();
        assertEquals(6,calculator.add("//;\n1;2;3"));
        assertEquals(6,calculator.add("//t\n1t2t3"));
        assertEquals(6,calculator.add("//\\\n1\\2\\3"));
    }
}
