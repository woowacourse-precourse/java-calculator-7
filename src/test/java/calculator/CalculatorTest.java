package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

class CalculatorTest {

    private Calculator calculator;

    @Test
    @DisplayName("공백 입력시 0을 출력한다.")
    void extractNumberWithSpace() {
        // given
        String text = "";
        calculator = new Calculator(text);

        // when
        int sum = calculator.sum();

        // then
        Assertions.assertEquals(sum, 0);
    }

    @Test
    @DisplayName("커스텀 구분자를 사용하여 숫자를 계산한다.")
    void extractNumberWithCustomDelimiter() {
        // given
        String includeCustomDelimiter = "//[\\n1,2:3[4";
        calculator = new Calculator(includeCustomDelimiter);

        // when
        int sum = calculator.sum();

        // then
        Assertions.assertEquals(sum, 10);
    }

    @Test
    @DisplayName("음수는 허용되지 않는다")
    void extractNumberNotNegative() {
        // given
        String text = "//-\n1-3,4:-5";
        calculator = new Calculator(text);

        // expected
        Assertions.assertThrows(IllegalArgumentException.class, () -> calculator.sum());
    }
}