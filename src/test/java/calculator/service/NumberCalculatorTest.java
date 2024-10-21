package calculator.service;

import calculator.domain.Numbers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static calculator.util.Const.NEGATIVE_NUMBER_ERROR_MESSAGE;
import static calculator.util.Const.NUMBER_FORMAT_ERROR_MESSAGE;
import static org.assertj.core.api.Assertions.*;

class NumberCalculatorTest {

    private NumberCalculator numberCalculator;

    @BeforeEach
    void setUp() {
        numberCalculator = new NumberCalculator();
    }

    @Test
    @DisplayName("유효한 숫자를 계산하여 Numbers 객체를 반환해야 한다.")
    void shouldCalculateValidNumbers() {
        String numberPart = "1,2,3";
        String splitForm = ",";

        Numbers numbers = numberCalculator.calculateNumbers(numberPart, splitForm);

        assertThat(numbers.getSum())
                .as("1, 2, 3을 더한 값은 6이어야 합니다.")
                .isEqualTo(6);
    }

    @Test
    @DisplayName("음수가 포함된 경우 예외를 발생시켜야 한다.")
    void shouldThrowExceptionForNegativeNumbers() {
        String numberPart = "1,-2,3";
        String splitForm = ",";

        assertThatThrownBy(() -> numberCalculator.calculateNumbers(numberPart, splitForm))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NEGATIVE_NUMBER_ERROR_MESSAGE);
    }

    @Test
    @DisplayName("숫자가 아닌 값이 포함된 경우 예외를 발생시켜야 한다.")
    void shouldThrowExceptionForNonNumericValues() {
        String numberPart = "1,abc,3";
        String splitForm = ",";

        assertThatThrownBy(() -> numberCalculator.calculateNumbers(numberPart, splitForm))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NUMBER_FORMAT_ERROR_MESSAGE);
    }

    @Test
    @DisplayName("다양한 구분자로 구분된 숫자들을 계산해야 한다.")
    void shouldHandleDifferentDelimiters() {
        String numberPart = "1;2;3";
        String splitForm = ";";

        Numbers numbers = numberCalculator.calculateNumbers(numberPart, splitForm);

        assertThat(numbers.getSum())
                .as("1, 2, 3을 더한 값은 6이어야 합니다.")
                .isEqualTo(6);
    }
}
