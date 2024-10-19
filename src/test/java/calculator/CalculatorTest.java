package calculator;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Calculator 단위 테스트")
class CalculatorTest {
    @Test
    @DisplayName("[성공] - calculate 메서드")
    void success_calculate() {
        //given
        Calculator calculator = new Calculator();
        List<Long> numbers = List.of(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L);

        //when
        long result = calculator.calculate(numbers);

        //then
        Assertions.assertThat(result).isEqualTo(45L);
    }

    @Test
    @DisplayName("[예외] - calculate 메서드(long 범위 초과)")
    void exception_calculate_overflow() {
        //given
        Calculator calculator = new Calculator();
        List<Long> numbers = List.of(9223372036854775807L, 1L);

        //when, then
        org.junit.jupiter.api.Assertions.assertThrows(ArithmeticException.class, () -> calculator.calculate(numbers));
    }
}