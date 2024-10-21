package calculator.domain;

import static calculator.domain.constant.errorMessage.ValueError.OUT_OF_RANGE_RESULT;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    @Test
    @DisplayName("결과 값이 int 범위를 초과하면 예외를 발생시킨다")
    void throwsExceptionWhenSumExceedsIntegerLimit() {
        Calculator calculator = new Calculator();
        List<Integer> numbers = List.of(Integer.MAX_VALUE, 1);

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> calculator.sum(numbers)
        );

        assertEquals(OUT_OF_RANGE_RESULT.getMessage(), exception.getMessage());
    }
}
