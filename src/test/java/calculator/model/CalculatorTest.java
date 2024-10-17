package calculator.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.SoftAssertions.assertSoftly;

public class CalculatorTest {

    @Test
    @DisplayName("문자열에서 숫자를 분리할 수 있다")
    public void separateNumberFromString() {
        assertSoftly(softly -> {
            softly.assertThat(Calculator.separateNumber("1,2,3,4,5", ",")).isEqualTo(new String[]{"1", "2", "3", "4", "5"});
            softly.assertThat(Calculator.separateNumber("1a2a3a4a5", "a")).isEqualTo(new String[]{"1", "2", "3", "4", "5"});
        });

    }
}
