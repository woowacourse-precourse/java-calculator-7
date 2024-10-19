package calculator.calculation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculationTest {

    private final Calculation calculator = Calculation.getInstance();

    @Test
    @DisplayName("정상적인 숫자 배열로 계산")
    void testCalculateWithValidNumbers() {
        // Given
        String[] numbers = {"1", "2", "3"};

        // When
        int result = calculator.calculate(numbers);

        // Then
        assertEquals(6, result);
    }

    @Test
    @DisplayName("빈 배열 입력 시 0 반환")
    void testCalculateWithEmptyArray() {
        // Given
        String[] numbers = {};

        // When
        int result = calculator.calculate(numbers);

        // Then
        assertEquals(0, result);
    }

    @Test
    @DisplayName("숫자가 아닌 값이 포함되었을 때 예외 발생")
    void testCalculateWithInvalidNumber() {
        // Given
        String[] numbers = {"1", "a", "3"};

        // When & Then
        assertThrows(IllegalArgumentException.class, () -> calculator.calculate(numbers));
    }
}
