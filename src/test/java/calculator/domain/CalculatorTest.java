package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CalculatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"//;\\n1,2:3;4", "1,2:3:4", "//[\\n1,2[3:4"})
    @DisplayName("calculator 계산 결과 반환 테스트")
    void testCalculateSuccess(String invalidInput) {
        // given
        Calculator calculator = new Calculator();
        Input input = new Input(invalidInput);
        int expected = 10;

        // when
        int actual = calculator.calculate(input);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}
