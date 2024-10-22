package calculator.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SumCalculatorTest {
    private final SumCalculator calculator = new SumCalculator();

    @Test
    @DisplayName("숫자의 합을 정확하게 계산한다")
    void calculateSum() {
        long[] numbers = {1, 2, 3};
        String result = calculator.calculateSum(numbers);
        assertEquals("6", result);
    }

    @Test
    @DisplayName("빈 배열 입력 시 0을 반환한다")
    void returnsZeroForEmptyArray() {
        long[] numbers = {};
        String result = calculator.calculateSum(numbers);
        assertEquals("0", result);
    }

    @Test
    @DisplayName("오버플로우 발생 시 예외를 던진다")
    void throwsExceptionOnOverflow() {
        long[] numbers = {Long.MAX_VALUE, 1};
        assertThrows(IllegalArgumentException.class, () -> calculator.calculateSum(numbers));
    }
}
