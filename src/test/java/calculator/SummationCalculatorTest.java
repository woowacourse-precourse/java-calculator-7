package calculator;

import static calculator.SummationCalculator.sum;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class SummationCalculatorTest {

    @Test
    void 숫자들의_총합_구하기() {
        int sum = sum(List.of(1, 2, 3, 4, 5));

        assertThat(sum).isEqualTo(15);
    }

    @Test
    void 전달받은_숫자가_없으면_0_반환() {
        int sum = sum(List.of());

        assertThat(sum).isEqualTo(0);
    }
}