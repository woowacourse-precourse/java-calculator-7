package calculator;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {
    private final Calculator calculator = new Calculator();

    @Test
    void 합계_계산_테스트() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        assertThat(calculator.sum(numbers)).isEqualTo(15);
    }

    @Test
    void 빈_리스트_합계_테스트() {
        List<Integer> numbers = Arrays.asList();
        assertThat(calculator.sum(numbers)).isEqualTo(0);
    }
}