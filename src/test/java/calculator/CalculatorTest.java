package calculator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import calculator.calculator.Calculator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        this.calculator = new Calculator();
    }

    @Test
    @DisplayName("생성자를 테스트한다.")
    void constructorTest() {
        Assertions.assertThat(calculator).isNotNull();
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "   "})
    @DisplayName("빈 값이 들어오면 0을 반환한다.")
    void whenEmptyStringIsGivenThenReturnZero(String emptyInput) {
        int calculated = calculator.calculate(emptyInput);
        Assertions.assertThat(calculated).isZero();
    }

    @ParameterizedTest
    @CsvSource(delimiter = '=', value = {"1,  2=3", "      1=1", "   3 ,  1 : 2  =6"})
    @DisplayName("숫자와 공백이 같이 주어지면 공백을 없애서 계산한다.")
    void replaceEmptyString(String emptyInput, int expected) {
        int calculated = calculator.calculate(emptyInput);
        Assertions.assertThat(calculated).isEqualTo(expected);
    }

    @Test
    @DisplayName("null 이 들어오면 예외가 발생한다.")
    void whenNullStringIsGivenThenThrowsException() {
        assertThatThrownBy(() -> calculator.calculate(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("쉼표나, 콜론을 포함한 문자열이 주어지면, 쉼포 혹은 콜론을 기준으로 구분하여 숫자로 변환 후 더한다.")
    @CsvSource(delimiter = '=', value = {"1,2,3=6", "0,1,2=3", "100,200,300=600", "1,2=3", "1:2=3", "1:2,3=6",
            "100,200:300=600"})
    void calculateByRestOrColon(String input, int expected) {
        int result = calculator.calculate(input);
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("음수가 주어지면 예외가 발생한다.")
    @ValueSource(strings = {"-1:-2,-3", "-1,5"})
    void throwsExceptionWhenInputContainsNegative(String input) {
        assertThatThrownBy(() -> calculator.calculate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}