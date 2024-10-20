package calculator.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void 정상적인_숫자_리스트_합() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        // when
        Integer result = calculator.addAll(numbers);

        // then
        assertEquals(15, result);
    }

    @Test
    void 정수_최대값_초과시_예외_발생() {
        // given
        List<Integer> numbers = List.of(Integer.MAX_VALUE, 1);

        // when & then
        assertThrows(IllegalArgumentException.class, () -> calculator.addAll(numbers));
    }
}
