package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringCalculatorTest {


    @Test
    @DisplayName("문자열로 된 숫자들의 합을 구한다.")
    void testSumNumbers() {
        // given
        String[] input1 = new String[]{"1", "2", "3"};
        String[] input2 = new String[]{"1"};

        // when
        int result1 = StringCalculator.sumNumbers(input1);
        int result2 = StringCalculator.sumNumbers(input2);

        // then
        assertThat(result1).isEqualTo(6);
        assertThat(result2).isEqualTo(1);
    }
}