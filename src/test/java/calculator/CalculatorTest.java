package calculator;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {
    @Test
    void 가산기_테스트() {
        // given
        Calculator calc = new Adder();
        int[] nums = {1, 2, 3};

        // when
        int result = calc.calculate(nums);

        // then
        assertEquals(result, 6);
    }
}
