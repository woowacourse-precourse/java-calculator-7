package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class SumCalculatorTest {

    private final Calculator calculator = new SumCalculator();

    @Test
    void 숫자_리스트의_합을_구한다() {
        //given
        List<Integer> numbers = List.of(123, 23, 1);

        //when
        int actual = calculator.sum(numbers);

        //then
        int expect = 147;
        assertThat(actual).isEqualTo(expect);
    }

}
