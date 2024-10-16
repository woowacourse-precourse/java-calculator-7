package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringSumCalculatorTest {

    private StringSumCalculator stringSumCalculator;

    @BeforeEach
    void setUp() {
        stringSumCalculator = new StringSumCalculator();
    }

    @DisplayName("양수 배열의 합을 계산")
    @Test
    void sumStringNumbers_양수() {
        String[] stringNumbers = {"1", "2", "3"};
        int result = stringSumCalculator.sumStringNumbers(stringNumbers);
        assertThat(result).isEqualTo(6);
    }

    @DisplayName("빈 배열에 대한 합은 0을 반환")
    @Test
    void sumStringNumbers_빈_배열() {
        String[] stringNumbers = {};
        int result = stringSumCalculator.sumStringNumbers(stringNumbers);
        assertThat(result).isEqualTo(0);
    }

    @DisplayName("숫자 하나만 있는 배열에 대한 합은 해당 숫자를 반환")
    @Test
    void sumStringNumbers_숫자_하나() {
        String[] stringNumbers = {"1"};
        int result = stringSumCalculator.sumStringNumbers(stringNumbers);
        assertThat(result).isEqualTo(1);
    }

    @DisplayName("0이 있는 경우 예외 발생")
    @Test
    void sumStringNumbers_영() {
        String[] stringNumbers = {"1", "0", "3"};
        assertThatThrownBy(() -> stringSumCalculator.sumStringNumbers(stringNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("양수가 아닌 값이 있습니다.");
    }

    @DisplayName("음수가 있는 경우 예외 발생")
    @Test
    void sumStringNumbers_음수() {
        String[] stringNumbers = {"1", "-2", "3"};
        assertThatThrownBy(() -> stringSumCalculator.sumStringNumbers(stringNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("양수가 아닌 값이 있습니다.");
    }
}