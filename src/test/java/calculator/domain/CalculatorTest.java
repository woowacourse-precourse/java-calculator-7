package calculator.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    @DisplayName("덧셈 계산")
    void 덧셈_계산() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4);

        // when
        int result = Calculator.add(numbers);

        // then
        assertThat(result).isEqualTo(10);
    }
}