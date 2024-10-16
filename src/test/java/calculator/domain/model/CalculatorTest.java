package calculator.domain.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import java.util.Collections;
import java.util.List;
import java.util.Arrays;

class CalculatorTest {

    @Test
    @DisplayName("빈 리스트의 합계는 0이어야 함")
    void testSumWithEmptyList() {
        List<Integer> numbers = Collections.emptyList();
        Calculator calculator = Calculator.of(numbers);
        long result = calculator.calculateSum();
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("단일 요소 리스트의 합계는 그 요소 자체여야 함")
    void testSumWithSingleElement() {
        List<Integer> numbers = Collections.singletonList(5);
        Calculator calculator = Calculator.of(numbers);
        long result = calculator.calculateSum();
        assertThat(result).isEqualTo(5);
    }

    @Test
    @DisplayName("여러 요소 리스트의 합계가 올바르게 계산되는지 확인")
    void testSumWithMultipleElements() {
        List<Integer> numbers = Arrays.asList(10, 20, 30, 40);
        Calculator calculator = Calculator.of(numbers);
        long result = calculator.calculateSum();
        assertThat(result).isEqualTo(100);
    }
}
