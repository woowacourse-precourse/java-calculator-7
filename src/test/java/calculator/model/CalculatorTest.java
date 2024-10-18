package calculator.model;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    @DisplayName("숫자 리스트 덧셈 - 계산에 성공한 경우")
    void calculateCorrectly() {
        //given
        List<Long> numbers = Arrays.asList(1L, 2L, 3L, 4L);
        Long expected = Long.valueOf(10L);

        //when
        Long result = calculator.calculate(numbers);

        //then
        Assertions.assertEquals(result, expected);
    }

    @Test
    @DisplayName("숫자 리스트 덧셈 - 오버플로우가 발생한 경우")
    void calculateWithOverflow() {
        //given
        List<Long> numbers = Arrays.asList(1L, 2L, Long.MAX_VALUE - 1);

        //when
        //then
        Assertions.assertThrows(IllegalArgumentException.class, () -> calculator.calculate(numbers));
    }
}