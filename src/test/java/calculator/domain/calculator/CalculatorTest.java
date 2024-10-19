package calculator.domain.calculator;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    private final Calculator calculator;

    public CalculatorTest() {
        this.calculator = new Calculator();
    }

    @Test
    void 전부_더하기_테스트() {
        // given
        List<Integer> numbers = Arrays.asList(1,2,3);

        // when
        final int result = calculator.sumAll(numbers);

        // then
        assertThat(result).isEqualTo(6);
    }
}
