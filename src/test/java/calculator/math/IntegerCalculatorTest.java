package calculator.math;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class IntegerCalculatorTest {

    @Test
    void sum_should_be_pass() {
        // given
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            list.add(i);
        }
        // when
        Calculator<Integer> calculator = new IntegerCalculator();
        Integer sum = calculator.sum(list);
        // then
        assertThat(sum).isEqualTo(45);
    }

}
