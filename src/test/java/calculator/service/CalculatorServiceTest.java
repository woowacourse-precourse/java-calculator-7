package calculator.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorServiceTest {

    private final CalculatorService calculatorService = CalculatorService.getInstance();

    @Test
    @DisplayName("정상 범위 내의 계산을 수행한다.")
    public void inRangeTest() {
        // GIVEN
        List<Long> numbers = List.of(1L, 2L, 3L, 4L, 5L);

        // WHEN
        Long result = calculatorService.calculateNumbers(numbers);

        // THEN
        assertThat(result).isEqualTo(15L);
    }

    @Test
    @DisplayName("계산 결과의 합이 Long 범위를 초과했을 경우 예외를 반환한다.")
    public void invalidRangeTest() {
        // GIVEN
        List<Long> numbers = List.of(1L, 2L, Long.MAX_VALUE, 5L);

        // WHEN-THEN
        assertThrows(IllegalArgumentException.class,
                () -> calculatorService.calculateNumbers(numbers));
    }
}
