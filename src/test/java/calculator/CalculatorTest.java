package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    void 빈_리스트를_입력하면_0을_반환() {
        List<Integer> numbers = Collections.emptyList();
        int result = calculator.add(numbers);
        assertThat(result).isEqualTo(0);
    }

    @Test
    void 숫자_하나를_포함한_리스트를_입력하면_해당_숫자를_반환() {
        List<Integer> numbers = Arrays.asList(5);
        int result = calculator.add(numbers);
        assertThat(result).isEqualTo(5);
    }

    @Test
    void 여러_숫자를_포함한_리스트를_입력하면_모든_숫자의_합을_반환한다() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        int result = calculator.add(numbers);
        assertThat(result).isEqualTo(15);
    }

    @Test
    void 모든_숫자가_0인_리스트를_입력하면_0을_반환한다() {
        List<Integer> numbers = Arrays.asList(0, 0, 0, 0);
        int result = calculator.add(numbers);
        assertThat(result).isEqualTo(0);
    }

}