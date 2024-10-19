package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;

class CalculatorTest {

    @Test
    void 모든_수의_합을_구한다() {
        // given
        List<PositiveNumber> numbers = NumberListConverter.toNumbers(
                new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"});

        // when
        PositiveNumber result = Calculator.sum(numbers);

        // then
        assertThat(result).isEqualTo(new PositiveNumber(55));
    }
}
