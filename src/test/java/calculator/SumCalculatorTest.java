package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class SumCalculatorTest {
    private static SumCalculator sumCalculator;

    @BeforeAll
    static void beforeAll() {
        sumCalculator = new SumCalculator();
    }

    @Test
    void 리스트에_숫자를_잘_더한다() {
        List<Integer> numbers = List.of(1, 5, 6);
        assertThat(sumCalculator.sum(numbers)).isEqualTo(12);
    }

    @Test
    void 빈_리스트일시_합계로_0을_반환한다() {
        List<Integer> numbers = new ArrayList<>();
        assertThat(sumCalculator.sum(numbers)).isEqualTo(0);
    }
}
