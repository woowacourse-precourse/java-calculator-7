package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class AdderTest {

    private Adder adder = new Adder();

    @DisplayName("숫자의 합 반한하기")
    @Test
    void calculateSumTest() {
        String[] numbers = {"1", "2", "3"};
        int expectedSum = 6;
        assertThat(adder.calculateSum(numbers)).isEqualTo(expectedSum);
    }
}
