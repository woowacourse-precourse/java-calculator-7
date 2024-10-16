package calculator.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private static final Calculator calculator = new Calculator();

    @Test
    @DisplayName("더하기 - 올바른 입력이 주어질 때 올바른 계산을 한다.")
    void givenValidInput_whenAdd_thenReturnsCorrectResult() {
        int[] input = new int[]{1, 2, 3, 4, 5};
        int expected = 15;
        int result = calculator.add(input);
        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("더하기 - 음수가 주어질 때 IllegalArgumentException을 던진다.")
    void givenNegativeNumber_whenAdd_thenThrowsIllegalArgumentException() {
        int[] input = new int[]{-1, 2, -1, 2};
        Assertions.assertThrows(IllegalArgumentException.class, () -> calculator.add(input));
    }

}