package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @Test
    void 숫자_리스트의_합이_최댓값을_초과하면_예외가_발생한다() {
        //given
        List<Integer> numbers = List.of(12, Integer.MAX_VALUE, 1);

        //when & then
        assertThatThrownBy(() -> calculator.sum(numbers))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("합계가 최대값을 초과했습니다.");
    }

}
