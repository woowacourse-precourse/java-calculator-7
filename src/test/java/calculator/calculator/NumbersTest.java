package calculator.calculator;

import static org.assertj.core.api.Assertions.assertThat;

import calculator.Number;
import calculator.Numbers;
import java.util.List;
import org.junit.jupiter.api.Test;

public class NumbersTest {

    @Test
    public void 숫자들의_합() {
        List<String> input = List.of("1", "3", "4", " ", "");
        Numbers numbers = Numbers.from(input);

        int sum = input.stream().filter(v -> !v.isBlank()).mapToInt(Integer::parseInt).sum();
        assertThat(numbers.sum()).isEqualTo(new Number(sum));
    }
}
