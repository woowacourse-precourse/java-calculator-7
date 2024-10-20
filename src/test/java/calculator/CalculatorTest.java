package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {

    @DisplayName("숫자 리스트 안의 숫자들을 모두 더한다.")
    @Test
    void calculate() {
        // given
        Calculator calculator = new Calculator();
        List<Integer> numbers = List.of(1,2,3);

        // when
        int result = calculator.calculate(numbers);

        // then
        assertThat(result).isEqualTo(6);
    }

    @DisplayName("빈 리스트가 입력되면 0을 반환한다.")
    @Test
    void calculate_emptyList() {
        // given
        Calculator calculator = new Calculator();
        List<Integer> numbers = List.of();

        // when
        int result = calculator.calculate(numbers);

        // then
        assertThat(result).isEqualTo(0);
    }
}