package calculator.operations;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorStrategyTest {

    @Test
    @DisplayName("숫자를 모두 더한 후 결과를 반환한다.")
    void addCalculate() {
        // given
        int[] numbers = {1, 2, 3};
        Calculator calculator = new Calculator(new AdditionStrategy());

        // when
        int result = calculator.execute(numbers);

        // then
        assertThat(result).isEqualTo(6);
    }

}