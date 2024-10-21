package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    @DisplayName("기본 구분자 쉼표(,)와 콜론(:)으로 문자열을 분리하여 합을 계산")
    void testCalculateWithDefaultDelimiters() {
        // given
        String input = "1,2:3";
        Calculator calculator = new Calculator(input);

        // when
        int result = calculator.calculateNumbers();

        // then
        assertEquals(6, result, "쉼표와 콜론으로 구분된 숫자의 합은 6이어야 합니다.");
    }

    @Test
    @DisplayName("커스텀 구분자 세미콜론(;)으로 문자열을 분리하여 합을 계산")
    void testCalculateWithCustomDelimiter() {
        // given
        String input = "//;\n1;2;3";
        Calculator calculator = new Calculator(input);

        // when
        int result = calculator.calculateNumbers();

        // then
        assertEquals(6, result, "커스텀 구분자 세미콜론으로 구분된 숫자의 합은 6이어야 합니다.");
    }

    @Test
    @DisplayName("빈 문자열을 입력한 경우 0을 반환")
    void testCalculateWithEmptyString() {
        // given
        String input = "";
        Calculator calculator = new Calculator(input);

        // when
        int result = calculator.calculateNumbers();

        // then
        assertEquals(0, result, "빈 문자열 입력 시 0이 반환되어야 합니다.");
    }

    @Test
    @DisplayName("음수가 포함된 경우 IllegalArgumentException 발생")
    void testNegativeNumberThrowsException() {
        // given
        String input = "1,2,-3";
        Calculator calculator = new Calculator(input);

        // then
        assertThrows(IllegalArgumentException.class, () -> {
            // when
            calculator.calculateNumbers();
        }, "음수가 포함된 경우 예외가 발생해야 합니다.");
    }

}
