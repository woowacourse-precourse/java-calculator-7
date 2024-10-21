package calculator.domain;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    @DisplayName("입력값을 바탕으로 계산 - 계산 성공한 경우")
    void calculateSum() {
        //given
        List<Long> numbers = Arrays.asList(1L, 2L, 3L);
        Long expected = 6L;

        //when
        Long actual = calculator.calculateSum(numbers);

        //then
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("입력값을 바탕으로 계산 - 음수가 포함되어 있어 실패한 경우")
    void calculateSumWithWrongInputFormat() {
        //given
        List<Long> numbers = Arrays.asList(1L, -1L);

        //when
        //then
        Assertions.assertThatThrownBy(() -> calculator.calculateSum(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력값을 바탕으로 계산 - 오버플로우가 발생해 실패한 경우")
    void calculateSumWithOverflow() {
        //given
        List<Long> numbers = Arrays.asList(1L, Long.MAX_VALUE);

        //when
        //then
        Assertions.assertThatThrownBy(() -> calculator.calculateSum(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }
}