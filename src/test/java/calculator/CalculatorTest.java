package calculator;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    @Test
    @DisplayName("모든 숫자의 총합을 계산한다")
    void testGetSummary() {
        //given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int expectedSummary = (10 * 11) / 2;
        Calculator calculator = new Calculator();
        //when
        int summary = calculator.getSummary(numbers);
        //then
        Assertions.assertThat(expectedSummary).isEqualTo(summary);
    }

}