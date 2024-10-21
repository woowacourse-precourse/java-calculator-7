package calculator.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringCalculatorTests {

    private static Calculator<Double> calculator;

    @BeforeAll
    static void setUp() {
        calculator = new StringCalculator<>((double)0, Double::sum, validNumber -> validNumber > 0);
    }

    @Test
    @DisplayName("추출해낸 숫자가 없으면 계산 결과는 0")
    public void calculateIfNoNumberFound() {
        List<Double> numberFound = List.of();
        double expectedTotal = 0;
        double result = calculator.calculate(numberFound);
        Assertions.assertEquals(expectedTotal, result);
    }

    @Test
    @DisplayName("추출해낸 숫자 중 양수가 아닌 값이 존재하면 예외 발생")
    public void throwExceptionIfNonPositiveContained() {
        List<Double> numbers = List.of(1.0, 0.0, 2.0, 3.0);

        assertThatThrownBy(() -> calculator.calculate(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }
}