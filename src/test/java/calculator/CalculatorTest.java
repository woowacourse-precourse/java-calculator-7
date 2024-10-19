package calculator;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    void 숫자의_합_계산_테스트() {
        List<Integer> numbers = List.of(1, 2, 3);
        assertThat(calculator.sumNumbers(numbers)).isEqualTo(6);
    }
}