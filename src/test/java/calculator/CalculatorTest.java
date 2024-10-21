package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void 빈_문자열을_입력하면_결과는_0() {
        // given
        String userInput = "";

        // when
        int result = calculator.processInputAndSum(userInput);

        // then
        assertThat(result).isEqualTo(0);
    }

    @Test
    void 구분자만_입력하면_결과는_0() {
        // given
        String comma = ",";
        String colon = ":";
        String custom = "//;\\n";

        // when
        int sumByComma = calculator.processInputAndSum(comma);
        int sumByColon = calculator.processInputAndSum(colon);
        int sumByCustom = calculator.processInputAndSum(custom);

        // then
        assertThat(sumByComma).isEqualTo(0);
        assertThat(sumByColon).isEqualTo(0);
        assertThat(sumByCustom).isEqualTo(0);
    }

    @Test
    void 숫자만_입력하면_결과는_입력값과_동일() {
        // given
        String singleDigitInput = "1";
        String multipleDigitsInput = "12";

        // when
        int resultForSingleDigit = calculator.processInputAndSum(singleDigitInput);
        int resultForMultipleDigits = calculator.processInputAndSum(multipleDigitsInput);

        // then
        assertThat(resultForSingleDigit).isEqualTo(1);
        assertThat(resultForMultipleDigits).isEqualTo(12);
    }
}
