package calculator.model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import calculator.fixture.CalculatorAppFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringSumCalculatorTest {

    private final StringSumCalculator stringSumCalculator = CalculatorAppFixture.createStringSumCalculator();

    @DisplayName("입력한 값이 빈값이라면 0을 반환한다.")
    @Test
    void isEmptyThenReturnZero() {
        assertSimpleTest(() -> {
            int result = stringSumCalculator.calculate("0");
            assertThat(result).isEqualTo(0);
        });
    }
}
