package calculator.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

public class CalculatorTest {

    Calculator calculator = new Calculator();
    Numbers numbers = new Numbers();

    @Test
    void 계산기_계산() {
        numbers.saveNumber(2);
        numbers.saveNumber(13);
        assertThat(calculator.calculate(numbers))
                .isEqualTo(15);
    }

    @Test
    void Numbers가_비었다면_0_리턴() {
        assertThat(calculator.calculate(numbers))
                .isEqualTo(0);
    }
}
