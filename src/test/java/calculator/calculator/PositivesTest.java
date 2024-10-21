package calculator.calculator;

import static org.assertj.core.api.Assertions.assertThat;

import calculator.Positive;
import calculator.Positives;
import java.util.List;
import org.junit.jupiter.api.Test;

public class PositivesTest {

    @Test
    public void 숫자들의_합() {
        List<String> input = numbersFixture();
        Positives positives = Positives.from(input);

        int sum = input.stream().filter(v -> !v.isBlank()).mapToInt(Integer::parseInt).sum();
        assertThat(positives.sum()).isEqualTo(new Positive(sum));
    }

    @Test
    public void 숫자변환() {
        List<String> input = numbersFixture();

        Positives positives = Positives.from(input);

        List<Positive> result = input.stream().map(Positive::from).toList();
        assertThat(positives).isEqualTo(new Positives(result));
    }

    private static List<String> numbersFixture() {
        return List.of("1", "3", "4", " ", "");
    }
}
