package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringCalculatorTest {


    @Test
    @DisplayName("문자열로 된 숫자들의 합을 구한다.")
    void testSumNumbers() {
        // given
        int[] input1 = new int[]{1, 2, 3};
        int[] input2 = new int[]{1};

        // when
        int result1 = StringCalculator.sumNumbers(input1);
        int result2 = StringCalculator.sumNumbers(input2);

        // then
        assertThat(result1).isEqualTo(6);
        assertThat(result2).isEqualTo(1);
    }
}