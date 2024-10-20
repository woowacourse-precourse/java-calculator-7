package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class StringCalculatorTest {

    @ParameterizedTest
    @DisplayName("StringCalculator는_입력_문자열_내_숫자의_합을_반환할_수_있다")
    @CsvSource(value = {"123 : 123", "//;\\n1,2:3;4 : 10", ",: : 0"}, delimiterString = " : ")
    public void calculate(String input, int expected) {
        //given
        StringCalculator calculator = new StringCalculator();
        InputString inputString = new InputString(input);

        //when
        int result = calculator.calculate(inputString);

        //then
        assertThat(result).isEqualTo(expected);
    }
}