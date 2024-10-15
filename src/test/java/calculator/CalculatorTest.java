package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CalculatorTest {

    @Test
    @DisplayName("생성자를 테스트한다.")
    void constructorTest() {
        Calculator calculator = new Calculator();
        Assertions.assertThat(calculator).isNotNull();
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "   "})
    @DisplayName("빈 값이 들어오면 0을 반환한다.")
    void whenEmptyStringIsGivenThenReturnZero(String emptyInput) {
        Calculator calculator = new Calculator();
        int calculated = calculator.calculate(emptyInput);
        Assertions.assertThat(calculated).isZero();
    }

    @Test
    @DisplayName("null 이 들어오면 예외가 발생한다.")
    void whenNullStringIsGivenThenThrowsException() {
        Calculator calculator = new Calculator();
        assertThatThrownBy(() -> calculator.calculate(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("쉼표나, 콜론을 포함한 문자열이 주어지면, 쉼포 혹은 콜론을 기준으로 구분하여 숫자로 변환 후 더한다.")
    @CsvSource(delimiter = '=', value = {"1,2,3=6", "0,1,2=3", "100,200,300=600", "1,2=3", "1:2=3", "1:2,3=6", "100,200:300=600"})
    void calculateByRestOrColon(String input, int expected) {
        Calculator calculator = new Calculator();
        int result = calculator.calculate(input);
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("음수가 주어지면 예외가 발생한다.")
    @ValueSource(strings = {"-1:-2,-3", "-1,5"})
    void throwsExceptionWhenInputContainsNegative(String input) {
        Calculator calculator = new Calculator();
        assertThatThrownBy(() -> calculator.calculate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}