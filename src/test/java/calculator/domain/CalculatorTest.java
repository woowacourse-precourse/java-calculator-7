package calculator.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CalculatorTest {

    @DisplayName("계산기 더하기 성공")
    @ParameterizedTest
    @ValueSource(strings = {"1,2:3", "//;\\n1;2;3"})
    void sumTest(String inputs) {
        // given

        // when
        Calculator calc = new Calculator(inputs);

        // then
        assertThat(calc.sum()).isEqualTo(6);
    }
}
