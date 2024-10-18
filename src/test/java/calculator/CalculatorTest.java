package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CalculatorTest {

    @Test
    public void 숫자를_모두_더한다() {
        //given
        int[] input = {1, 2, 3};
        Calculator calculator = new PositiveCalculator();

        //when
        int result = calculator.add(input);

        //then
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void 입력이_없을_때_0을_반환한다() {
        //given
        int[] input = {};
        Calculator calc = new PositiveCalculator();

        //when
        int result = calc.add(input);

        //then
        assertThat(result).isEqualTo(0);
    }
}