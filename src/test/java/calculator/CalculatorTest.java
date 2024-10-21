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
        int sumForComma = calculator.processInputAndSum(comma);
        int sumForColon = calculator.processInputAndSum(colon);
        int sumForCustom = calculator.processInputAndSum(custom);

        // then
        assertThat(sumForComma).isEqualTo(0);
        assertThat(sumForColon).isEqualTo(0);
        assertThat(sumForCustom).isEqualTo(0);
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

    @Test
    void 여러_자리_숫자로_구성된_문자열_계산() {
        // given
        String defaultDelimiterAndMultipleDigits = "1,12:123";
        String customDelimiterAndMultipleDigits = "//;\\n1;12;123";

        // when
        int sumForDefaultDelimiter = calculator.processInputAndSum(defaultDelimiterAndMultipleDigits);
        int resultForCustomDelimiter = calculator.processInputAndSum(customDelimiterAndMultipleDigits);

        // then
        assertThat(sumForDefaultDelimiter).isEqualTo(136);
        assertThat(resultForCustomDelimiter).isEqualTo(136);
    }

}
