package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import calculator.domain.Calculator;
import calculator.domain.PositiveCalculator;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    @Test
    public void 숫자를_모두_더한다() {
        //given
        int[] input = {1, 2, 3};
        Calculator calculator = new PositiveCalculator(input);

        //when
        int result = calculator.sum();

        //then
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void 입력이_없을_때_0을_반환한다() {
        //given
        int[] input = {};
        Calculator calc = new PositiveCalculator(input);

        //when
        int result = calc.sum();

        //then
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void 숫자는_음수가_아니여야_한다() {
        //given
        int[] input = {-1, 2, 3};

        //then
        assertThrows(IllegalArgumentException.class, () -> new PositiveCalculator(input));
    }

    @Test
    public void 숫자는_0이_아니여야_한다() {
        //given
        int[] input = {1, 2, 3, 0};

        //then
        assertThrows(IllegalArgumentException.class, () -> new PositiveCalculator(input));
    }
}