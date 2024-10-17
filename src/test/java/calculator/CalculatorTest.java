package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

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
}