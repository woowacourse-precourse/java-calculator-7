package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @DisplayName("올바른 예시 동작 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1,2:3,,4", "//;\\n1;2;3,:4"})
    void calculateResultTest_1(String expression) {
        Calculator calculator = new Calculator();
        int result = calculator.calculateResult(expression);
        assertEquals(10, result);
    }

    @DisplayName("올바르지 않은 예시 동작 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1,2:3,,;4", "//;\n1;2;3,:4", "-1-2-3:4"})
    void calculateResultTest_2(String expression) {
        Calculator calculator = new Calculator();
        assertThatThrownBy(() -> calculator.calculateResult(expression))
                .isInstanceOf(IllegalArgumentException.class);
    }
}