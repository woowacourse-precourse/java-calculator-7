package calculator.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import util.Calculator;

public class CalculatorTest {

    @Test
    void 넘겨받은_숫자배열_총합() {
        //given
        int[] numbers = {1, 2, 3, 4};
        //when
        int result = Calculator.getSum(numbers);
        //then
        assertThat(result).isEqualTo(10);
    }
}
